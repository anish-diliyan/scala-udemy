package playground

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.coalesce

case class CounterPartyTable(
                         counterparty_id: Int,
                         cp_name: String,
                         cp_address: String,
                         csp_bus_date: String,
                         csp_execution_id: String
                       )
case class CounterParty(
                       cp_name: String,
                       cp_address: String,
                       csp_bus_date: String,
                       csp_execution_id: String
                     )

object DataFrames {
  val transactions: Seq[CounterParty] = Seq(
    CounterParty("charu mehta", "mumbai", "15-01-2025", "for_rmbsa"),
    CounterParty("anish", "patna", "15-01-2025", "for_rmbsa"),
    CounterParty("shobana", "banglore", "15-01-2025", "for_rmbsa")
  )
}
object DataBases {
  val stagingTable: Seq[CounterPartyTable] = Seq(
    CounterPartyTable(1000000, "charu mehta", "mumbai", "15-01-2025", "for_rmbsa"),
    CounterPartyTable(2000000, "anish", "patna", "15-01-2025", "for_rmbsa")
  )
  val masterTable: Seq[CounterPartyTable] = Seq(
    CounterPartyTable(3000000, "shobana", "banglore", "15-01-2025", "for_rmbsa"),
  )
}
object JoinExample1 extends App {

  val spark = SparkSession.builder()
    .appName("JoinExample1")
    .config("spark.master", "local")
    .getOrCreate()

  import spark.implicits._
   val transactionsDF = DataFrames.transactions.toDF()
   val stagingTableDF = DataBases.stagingTable.toDF()
   val masterTableDF = DataBases.masterTable.toDF()


  val joinColumns = Seq("cp_name", "cp_address")

  val transactionWithCpIdDF = transactionsDF.join(
    stagingTableDF,
    joinColumns.map(col => transactionsDF(col) <=> stagingTableDF(col)).reduce(_ && _),
    "left"
  ).select(transactionsDF("*"), stagingTableDF("counterparty_id"))

  transactionWithCpIdDF.show()

  val finalDF = transactionWithCpIdDF.join(masterTableDF,
      joinColumns.map(col => transactionWithCpIdDF(col) <=> masterTableDF(col)).reduce(_ && _),
      "left")
    .select(
      transactionWithCpIdDF.columns.map(c =>
        if (c == "counterparty_id")
          coalesce(transactionWithCpIdDF("counterparty_id"), masterTableDF("counterparty_id")).as("counterparty_id")
        else
          transactionWithCpIdDF(c)
      ): _*
    )
  finalDF.show()

}
