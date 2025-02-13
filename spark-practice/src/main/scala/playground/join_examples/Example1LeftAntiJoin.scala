package playground.join_examples

import constants.ImplicitConstants._
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

case class Transaction(cp_name: String, cp_address: String, cp_bank_name: String, cp_bank_acct_num: String)
case class Staging(cp_name: String, cp_address: String, cp_bank_name: String, cp_bank_acct_num: String)

object Example1LeftAntiJoin extends App {
  private val transaction = Seq(
    Transaction("John Doe", "123 Main St", "Bank A", "123456"),
    Transaction("Jane Smith", "456 Elm St", "Bank B", "789012"),
    Transaction("Bob Johnson", "789 Oak St", "Bank C", "345678"),
    Transaction("Alice Brown", "321 Pine St", "Bank D", "901234"),
    Transaction("Charlie Davis", "654 Maple St", "Bank E", "567890")
  )
  private val staging = Seq(
    Staging("John Doe", "123 Main St", "Bank A", "123456"),
    Staging("Jane Smith", "456 Elm St", "Bank B", "789012"),
  )

  private val transactionDF = spark.createDataFrame(transaction)
  private val stagingDF = spark.createDataFrame(staging)

  private val matchingColumns = Seq("cp_name", "cp_address", "cp_bank_name", "cp_bank_acct_num")

  private def createMatchKey(df: DataFrame): DataFrame = {
    df.withColumn(
      "match_key", concat_ws("||", matchingColumns.map(colName =>
          when(col(colName).isNull || trim(col(colName)) === "", lit("")).otherwise(trim(col(colName)))): _*
      )
    )
  }

  private def removeExistingInStaging(stagingDf: DataFrame, transactionDF: DataFrame): DataFrame = {
    val txnWithKey = createMatchKey(transactionDF)
    val stagingWithKey = createMatchKey(stagingDf)

    txnWithKey.join(
      stagingWithKey.select("match_key"),
      Seq("match_key"),
      "left_anti"  // Keep only transactions that don't match with staging
    ).drop("match_key")  // Remove the match_key column
  }

  removeExistingInStaging(stagingDF, transactionDF).show()
}
