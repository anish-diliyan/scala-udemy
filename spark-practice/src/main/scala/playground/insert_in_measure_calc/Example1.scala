package playground.insert_in_measure_calc

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
import constants.ImplicitConstants._
import spark.implicits._

case class MeasureList(measure_id: String, measure_name: String)

case class Transaction(id: Int, counterparty_id: String, csp_bus_dt: String, csp_is_synonym: Boolean)

object InsertInMeasureCalc extends App {

  val measureList: Seq[MeasureList] = Seq(
    MeasureList("1", "csp_is_synonym")
  )
  val measureListDf = spark.createDataFrame(measureList)

  val transactionData = Seq(
    Transaction(1, "CP001", "2024-01-01", csp_is_synonym = true),
    Transaction(2, "CP002", "2024-01-01", csp_is_synonym = false),
    Transaction(3, "CP003", "2024-01-01", csp_is_synonym = true),
    Transaction(4, "CP004", "2024-01-02", csp_is_synonym = false),
    Transaction(5, "CP005", "2024-01-02", csp_is_synonym = true)
  )

  val transactionDf = spark.createDataFrame(transactionData)

  def findMeasureCalcDF(transactionDf: DataFrame): DataFrame = {
    // Define columns as constants to avoid repeated string creation
    val CSP_RECORD_ID = "csp_record_id"
    val COUNTERPARTY_ID = "counterparty_id"
    val CSP_BUS_DT = "csp_bus_dt"
    val MEASURE_ID = "measure_id"
    val MEASURE_VALUE = "measure_value"
    val MEASURE_NAME = "measure_name"
    val CSP_IS_SYNONYM = "csp_is_synonym"

    val measureId = measureListDf
      .filter(col(MEASURE_NAME) === CSP_IS_SYNONYM)
      .select(MEASURE_ID)
      .first()
      .getString(0)

    // Create a projection of only needed columns upfront
    val filteredDf = transactionDf
      .where(col(CSP_IS_SYNONYM))
      .select(COUNTERPARTY_ID, CSP_BUS_DT)

    // Optimize the transformation with a single select
    filteredDf
      .select(
        lit("1").as(CSP_RECORD_ID),
        col(COUNTERPARTY_ID),
        col(CSP_BUS_DT),
        //lit(measureId.value).as(MEASURE_ID),
        lit("true").as(MEASURE_VALUE)
      )
      .repartition(col(CSP_BUS_DT)) // Add if you frequently query by business date
      .sortWithinPartitions(col(COUNTERPARTY_ID)) // Optimize for subsequent operations
  }


  // Call the function and show results
  val resultDf = findMeasureCalcDF(transactionDf)

  println("Original Transaction DataFrame:")
  transactionDf.show()

  println("\nResult DataFrame:")
  resultDf.show()
}
