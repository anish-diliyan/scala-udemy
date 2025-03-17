package practice_ms

import models.SourceModel._
import models.TablesModel.{CpMaster, CpTxnMap}
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

object GenerateCpIdFlow extends App {
  val cpTxnMapTable: Seq[CpTxnMap] = Seq(
    CpTxnMap(100, "100")
  )
  val cpMasterTable: Seq[CpMaster] = Seq(
    CpMaster(100, "Nikhil", "Mumbai, Maharastra", "91", "Sbi_33", "2", "State Bank Of India", "Kalyan, Mumbai", "EBOSS", "WM_AUS", "2025-01-28")
  )
  val incoming: Seq[Incoming] = Seq(
    Incoming("Anish", "Ara, Bihar", "Axis_11", "1", "Axis Bank", "katira, Ara", "EBOSS", "WM_AUS", "2025-01-28", "100"),
    Incoming("Anish", "Ara, Bihar", "Axis_11", "1", "Axis Bank", "katira, Ara", "EBOSS", "WM_AUS,", "2025-01-28", "101")
  )
  val outgoing: Seq[Outgoing] = Seq(
    Outgoing("Charushila", "Mumbai, Maharastra", "Sbi_11", "2", "State Bank Of India", "Kalyan, Mumbai", "EBOSS", "WM_AUS", "2025-01-29", "102"),
    Outgoing("Shobana", "Bangluru, Karnatka", "Sbi_22", "2", "State Bank Of India", "Greater, Bangluru", "EBOSS", "WM_AUS", "2025-01-29", "103"),
    Outgoing("Nikhil", "Mumbai, Maharastra", "Sbi_33", "2", "State Bank Of India", "Kalyan, Mumbai", "EBOSS", "WM_AUS", "2025-01-29", "104"),
  )

  def processCounterpartyData(incomingDF: DataFrame, outgoingDF: DataFrame, cpMasterTableDF: DataFrame): (DataFrame, DataFrame) = {
    // Extract counterparty columns from both incoming and outgoing DFs
    val incomingCPs = incomingDF.select(
      col("counterparty_name"),
      col("counterparty_address"),
      col("cp_bank_id")
    ).distinct()

    val outgoingCPs = outgoingDF.select(
      col("counterparty_name"),
      col("counterparty_address"),
      col("cp_bank_id")
    ).distinct()

    // Union incoming and outgoing counterparties and remove duplicates
    val allCPs = incomingCPs.union(outgoingCPs).distinct()

    // Find new counterparties by anti-joining with existing master table
    val newCPs = allCPs.join(
      cpMasterTableDF,
      Seq("counterparty_name", "counterparty_address", "cp_bank_id"),
      "leftanti"  // Gets only records that don't exist in cpMasterTableDF
    )

    // Generate new CP IDs for new counterparties
    val maxExistingCpId = if (cpMasterTableDF.isEmpty) {
      99  // Start from 100 for new CPs
    } else {
      cpMasterTableDF.agg(max("cp_id").as("max_cp_id")).first().getLong(0)
    }

    // Add CP IDs to new counterparties
    val newCPsWithIds = newCPs.withColumn(
      "cp_id",
      row_number().over(Window.orderBy("counterparty_name")) + lit(maxExistingCpId)
    )

    // Create updated master table
    val updatedMasterTable = cpMasterTableDF.union(newCPsWithIds)

    // Create transaction mapping table by joining with master table
    val incomingWithCpIds = incomingDF.join(
      updatedMasterTable,
      Seq("counterparty_name", "counterparty_address", "cp_bank_id")
    )

    val outgoingWithCpIds = outgoingDF.join(
      updatedMasterTable,
      Seq("counterparty_name", "counterparty_address", "cp_bank_id")
    )

    val cpTxnMapTable = incomingWithCpIds.union(outgoingWithCpIds)

    (updatedMasterTable, cpTxnMapTable)
  }


}
