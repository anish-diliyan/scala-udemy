package transaction.helper

import constants.AccountIdTypeId._
import constants.ProcessContext
import constants.TableColumnName.{AML_TRANS_KEY, NAME, ORIG_NAME}
import org.apache.spark.internal.Logging
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.col
import utils.DataFrameUtils
import implicits.CpUtilityImplicits._

object TransactionsReadHelper extends Logging {

  def processTransaction(sources: Seq[AccountIdTypeId])(implicit processCtx: ProcessContext): DataFrame = {
    logInfo(s"Processing transactions for ${sources.mkString(",")} and date = ${processCtx.cspBusDt} and executionId = ${processCtx.executionId}")
    val transactionDataFrames = for(source <- sources) yield processAtSourceSystemLevel(source)
    val processedTransactionDF = transactionDataFrames match {
      case Seq(_, _*) => DataFrameUtils.sefUnionAsMissingColumnAsNUll(transactionDataFrames).get
      case _ => transactionDataFrames.head
    }
    processedTransactionDF.show()
    processedTransactionDF
  }

  private def processAtSourceSystemLevel(source: AccountIdTypeId)(implicit processCtx: ProcessContext): DataFrame = {
    val processedSourceDF = source match {
      case EBOSS => ProcessEbossHelper.processEboss
      case RMBSA => ProcessRmbsaHelper.processRmbsa
    }
    processedSourceDF.withColumn(ORIG_NAME, col(NAME)).dropDuplicates(AML_TRANS_KEY).cleanse
  }

}
