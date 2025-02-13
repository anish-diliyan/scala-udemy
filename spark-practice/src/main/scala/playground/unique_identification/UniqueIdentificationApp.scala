package playground.unique_identification

import constants.ImplicitConstants.spark
import constants.SourceToTableMapping._
import playground.unique_identification.SourceData._
import functions.ImplicitFunctions._
import org.apache.spark.sql.functions.lit
import playground.unique_identification.TablesData.{cpMaster, cpStagingDaily}

object UniqueIdentificationApp extends App {

  val incomingDF = spark.createDataFrame(incoming)
    .renameColumn(incomingToCpStagingDaily)
    .withColumn("trans_type", lit("incoming"))

  val outgoingDF = spark.createDataFrame(outgoing)
    .renameColumn(outgoingToCpStagingDaily)
    .withColumn("trans_type", lit("outgoing"))

  val transactionDF = incomingDF.union(outgoingDF).generateUniqueId
  transactionDF.show()

  val masterDF = spark.createDataFrame(cpMaster)
  val stagingDF = spark.createDataFrame(cpStagingDaily)


  val existingCPWithID = transactionDF.findUnique.addCounterPartyId(masterDF, stagingDF)
  val cpWithID = generateNewCPID(existingCPWithID)


  // check counterparty_id in cpWithId dataframe and add in transactionDF with unique_id is matching
  val result = transactionDF
    .join(
      cpWithID.select("unique_id", "counterparty_id").as("cp_with_id"),
      transactionDF.col("unique_id") === cpWithID.col("unique_id"),
      "left"
    )

  result.show()
}
