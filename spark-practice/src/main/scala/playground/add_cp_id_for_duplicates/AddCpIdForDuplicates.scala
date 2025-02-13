package playground.add_cp_id_for_duplicates

import constants.ImplicitConstants._
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.{col, when}

case class Transaction(uniqueId: String, amount: Int)
case class TransactionWithCpId(uniqueId: String, amount: Int, cpId: String)

object AddCpIdForDuplicates extends App {

  val transactions = List(
    Transaction("1", 100),
    Transaction("2", 200),
    Transaction("3", 300),
    Transaction("1", 100),
    Transaction("2", 200),
    Transaction("3", 300)
  )

  val transactionWithCpId = List(
    TransactionWithCpId("1", 100, "1"),
    TransactionWithCpId("2", 200, "2"),
    TransactionWithCpId("3", 300, "3")
  )

  val transactionDF = spark.createDataFrame(transactions)
  val transactionWithCpIdDF = spark.createDataFrame(transactionWithCpId)

  // add cpId in transactionsDF if transactions exists in transactionsWithCpIdDF and remember same  cpID should be added
  // if same uniqueId
  def addCpIdFromExisting(): DataFrame = {
    // Join with transactionsWithCpIdDF based on uniqueId to get cpId
    transactionDF.as("txn").join(
        transactionWithCpIdDF.select("uniqueId", "cpId").as("existing"),  // Add alias for transactionWithCpIdDF
        col("txn.uniqueId") === col("existing.uniqueId"),  // Use qualified column names
        "left"
      ).select(
        transactionDF.columns.map(colName => col(s"txn.$colName")) :+  // Qualify original columns
          col("existing.cpId"): _*
      )
  }


  val result = addCpIdFromExisting()
  result.show(false)
}
