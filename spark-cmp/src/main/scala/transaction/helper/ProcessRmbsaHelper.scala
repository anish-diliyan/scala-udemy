package transaction.helper

import constants.NameConstants.{AML_RGN_CD, CR_DR_CD, SRC_SYS_ID, SRC_SYS_TRAN_STYP, SRC_SYS_TRAN_TYP}
import constants.{AccountIdTypeId, ProcessContext}
import implicits.TableToDfImplicits.TransactionRead
import org.apache.spark.internal.Logging
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.col

object ProcessRmbsaHelper extends Logging {

  def processRmbsa(implicit processCtx: ProcessContext): DataFrame = {
    val transactionDf: DataFrame = processCtx.getTransactions(AccountIdTypeId.RMBSA)
    val rmbsaDataFrame = transactionDf.filter(
      col(SRC_SYS_TRAN_TYP) === "CS" &&
        col(SRC_SYS_TRAN_STYP) === "WI" &&
        col(SRC_SYS_ID) === "RMBSA" &&
        col(AML_RGN_CD) === "SA"
    )
    // filter incoming transaction
    val rmbsaIncomingDF = rmbsaDataFrame.filter(col(CR_DR_CD) === "I")
    // filter outgoing transaction
    val rmbsaOutgoingDF = rmbsaDataFrame.filter(col(CR_DR_CD) === "O")
    rmbsaIncomingDF.union(rmbsaOutgoingDF)
  }

}
