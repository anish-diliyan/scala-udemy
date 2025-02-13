package playground.csp_is_overriden

import Source._
import functions.UtilityFunctions
import constants.ImplicitConstants._
import functions.ImplicitFunctions._
import constants.SourceToTableMapping._

object CspIsOverridden extends App {

  val outgoingDF = spark.createDataFrame(outgoing).renameColumn(outgoingToCpStagingDaily)
  val incomingDF = spark.createDataFrame(incoming).renameColumn(incomingToCpStagingDaily)

  val transactionDF = incomingDF.union(outgoingDF)

  val transactionWithCpId = UtilityFunctions.addCounterpartyId(transactionDF)

  val transactionWithUltimateCpId = UtilityFunctions.addUltimateCounterpartyId(transactionWithCpId)

  transactionWithUltimateCpId.show()
}
