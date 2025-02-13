package playground.csp_source_field_name

import constants.ImplicitConstants._
import org.apache.spark.sql.{Column, DataFrame}
import org.apache.spark.sql.functions._

case class Transaction(cpName: String, cpAddress: String, txnType: String, txnKey: String)

object CspSourceFieldName extends App {

  val transactions = List(
    Transaction("", "cp1_address", "incoming", "i1"),
    Transaction("cp2", "", "incoming", "i2"),
    Transaction("cp3", "cp3_address", "incoming", "i3"),
    Transaction(null, " ", "incoming", "i4"),

    Transaction("", "cp4_address", "outgoing", "o1"),
    Transaction("cp5", "", "outgoing", "o2"),
    Transaction("cp6", "cp6_address", "outgoing", "o3"),
    Transaction( null, "", "outgoing", "o4")
  )


  private val transactionDf = spark.createDataFrame(transactions)

  private def cspSourceName(transactionDF: DataFrame): DataFrame = {

    // Helper function to check if a column has value
    def hasValue(colName: String): Column = {
      col(colName).isNotNull && trim(col(colName)) =!= ""
    }

    // Helper function to get source name based on type and availability
    def getSourceName(prefix: String): Column = {
      when(
        hasValue("cpName") && !hasValue("cpAddress"),
        s"${prefix}_nm"
      ).when(
        !hasValue("cpName") && hasValue("cpAddress"),
        s"${prefix}_addr"
      ).when(
        hasValue("cpName") && hasValue("cpAddress"),
        s"${prefix}_nm_addr"
      )
    }

    transactionDF
      // Remove rows where both fields are missing
      .filter(hasValue("cpName") || hasValue("cpAddress"))
      // Add csp_source_name
      .withColumn(
        "csp_source_name",
        when(
          col("txnType") === "incoming",
          getSourceName("orig")
        ).otherwise(
          getSourceName("recipient")
        )
      )
  }

  val resultDF: DataFrame = cspSourceName(transactionDf)

  resultDF.show()

}
