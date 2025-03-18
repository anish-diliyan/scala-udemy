package transaction.helper

import constants.AccountIdTypeId._
import constants.ProcessContext
import org.apache.spark.internal.Logging
import org.apache.spark.sql.DataFrame

object TransactionsReadHelper extends Logging {

  def processTransaction(sources: Seq[AccountIdTypeId])(implicit processCtx: ProcessContext): Unit = {
    logInfo(s"Processing transactions for ${sources.mkString(",")} and date = ${processCtx.cspBusDt} and executionId = ${processCtx.executionId}")

    val transactionDF = for(source <- sources) yield processAtSourceSystemLevel(source)
  }

  private def processAtSourceSystemLevel(source: AccountIdTypeId)(implicit processCtx: ProcessContext): DataFrame = {
    val processedSourceDF = source match {
      case EBOSS => ProcessEbossHelper.processEboss
      case RMBSA => ProcessRmbsaHelper.processRmbsa
      case USWM => ProcessUswmHelper.processUswm
      case ETRADE => ProcessEtradeHelper.processEtrade
      case ISG => ProcessIsgHelper.processIsg
    }
    processedSourceDF
  }

}
