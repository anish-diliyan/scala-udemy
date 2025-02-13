package functions

import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.{Column, DataFrame, Dataset, Row}

import java.sql.Timestamp
import java.text.SimpleDateFormat
import org.apache.spark.sql.functions._

object ImplicitFunctions {

  implicit class StringToTimestamp(val str: String) extends AnyVal {
    def toTimestamp: Timestamp = {
      val dateFormat = new SimpleDateFormat("yyyy-MM-dd")
      val parsedDate = dateFormat.parse(str)
      new Timestamp(parsedDate.getTime)
    }
  }

  implicit class RenameColumns(df: DataFrame) {
    def renameColumn(renameMap: Map[String, String]): DataFrame = {
      renameMap.foldLeft(df)((df, rename) => df.withColumnRenamed(rename._1, rename._2))
    }
  }

  implicit class UniqueIdentification(private val transactionDF: DataFrame) {
    private val columnsToProcess = Array("cp_name", "cp_address", "cp_bank_acct_num", "cp_bank_id", "cp_bank_name", "cp_bank_address")
    private def processColumn(colName: String): Column = {
      when(
        col(colName).isNull || trim(col(colName)) === "", lit("")
      ).otherwise(trim(col(colName)))
    }
    def generateUniqueId: DataFrame = {
      val concatenatedFields = concat_ws("||", columnsToProcess.map(processColumn): _*)
      transactionDF.select(col("*"),sha2(concatenatedFields, 256).as("unique_id"))
    }

    def findUnique: DataFrame = transactionDF.dropDuplicates(columnsToProcess)
  }

  import org.apache.spark.sql.{DataFrame, functions => F}

  implicit class ExistingIdentification(private val transactionDF: DataFrame) {
    // Define matching columns
    private val matchingColumns = Seq(
      "cp_name",
      "cp_address",
      "cp_bank_name",
      "cp_bank_acct_num"
    )

    private def createMatchKey(df: DataFrame): DataFrame = {
      df.withColumn(
        "match_key",
        F.concat_ws("||",
          matchingColumns.map(col =>
            F.when(
              F.col(col).isNull || F.trim(F.col(col)) === "",
              F.lit("")
            ).otherwise(F.trim(F.col(col)))
          ): _*
        )
      )
    }

    def addCounterPartyId(masterDf: DataFrame, stagingDf: DataFrame): DataFrame = {
      // Add match keys to all DataFrames
      val txnWithKey = createMatchKey(transactionDF)
      val masterWithKey = createMatchKey(masterDf)
      val stagingWithKey = createMatchKey(stagingDf)

      // Join with master first
      val withMasterMatch = txnWithKey
        .join(
          masterWithKey.select("match_key", "counterparty_id").as("master"),
          Seq("match_key"),
          "left"
        )

      // Join with staging and combine counterparty_ids
      val result = withMasterMatch
        .join(
          stagingWithKey.select("match_key", "counterparty_id").as("staging"),
          Seq("match_key"),
          "left"
        )
        .withColumn(
          "match_source",
          F.when(F.col("master.counterparty_id").isNotNull, "MASTER")
            .when(F.col("staging.counterparty_id").isNotNull, "STAGING")
            .otherwise("NO_MATCH")
        )
        .withColumn(
          "final_counterparty_id",  // Using a temporary column name
          F.coalesce(
            F.col("master.counterparty_id"),
            F.col("staging.counterparty_id")
          )
        )
        .select(
          transactionDF.columns.map(F.col) :+
            F.col("final_counterparty_id").as("counterparty_id") :+  // Rename in final select
            F.col("match_source"): _*
        )

      result
    }
  }

  def generateNewCPID(transactionDF: DataFrame): DataFrame = {
    val existingCP = transactionDF.filter(col("counterparty_id").isNotNull)
    val newCP = transactionDF.filter(col("counterparty_id").isNull)
    generateID(newCP).union(existingCP)
  }

  def generateID(df: DataFrame): DataFrame = {
    val windowSpec = Window.orderBy(lit(1))
    df.withColumn("counterparty_id", row_number().over(windowSpec) + 100)
  }

}
