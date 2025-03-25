package transaction.helper

import constants.NameConstants.{AML_RGN_CD, CR_DR_CD, SRC_SYS_ID, SRC_SYS_TRAN_STYP, SRC_SYS_TRAN_TYP}
import constants.{AccountIdTypeId, ProcessContext}
import org.apache.spark.internal.Logging
import org.apache.spark.sql.DataFrame
import implicits.TableToDfImplicits._
import org.apache.spark.sql.functions.col

object ProcessEbossHelper extends Logging {

  def processEboss(implicit processCtx: ProcessContext): DataFrame = {
    val transactionDf: DataFrame = processCtx.getTransactions(AccountIdTypeId.EBOSS)
    val ebossDataFrame = transactionDf.filter(
      col(SRC_SYS_TRAN_TYP) === "CS" &&
        col(SRC_SYS_TRAN_STYP) === "WI" &&
        col(SRC_SYS_ID) === "EBOSS" &&
        col(AML_RGN_CD) === "AUS"
    )
    // filter incoming transaction
    val ebossIncomingDF = ebossDataFrame.filter(col(CR_DR_CD) === "I")
    // filter outgoing transaction
    val ebossOutgoingDF = ebossDataFrame.filter(col(CR_DR_CD) === "O")
    ebossIncomingDF.union(ebossOutgoingDF)
  }

}
