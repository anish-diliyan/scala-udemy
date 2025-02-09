package morgan.process

import morgan.constants.SourceToTableMapping._
import morgan.source.Source._
import morgan.utils.ImplicitFunctions._
import morgan.utils.ImplicitConstants._
import morgan.utils.UtilityFunctions

object CspIsOverridden extends App {

  val outgoingDF = spark.createDataFrame(outgoing).renameColumn(outgoingToCpStagingDaily)
  val incomingDF = spark.createDataFrame(incoming).renameColumn(incomingToCpStagingDaily)

  val transactionDF = incomingDF.union(outgoingDF)

  val transactionWithCpId = UtilityFunctions.addCounterpartyId(transactionDF)

  val transactionWithUltimateCpId = UtilityFunctions.addUltimateCounterpartyId(transactionWithCpId)

  transactionWithUltimateCpId.show()
}
