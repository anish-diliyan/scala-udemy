package transaction.helper

import constants.NameConstants.{AML_RGN_CD, AML_TRANS_KEY, CR_DR_CD, CSP_BUS_DT, INCOMING, ORIG_ADDR, ORIG_BNK_ACCT, ORIG_BNK_ADDR, ORIG_BNK_ID, ORIG_BNK_NM, ORIG_NM, ORIG_SYS_ID, OUTGOING, RECIPIENT_ADDR, RECIPIENT_BNK_ACCT, RECIPIENT_BNK_ADDR, RECIPIENT_BNK_ID, RECIPIENT_BNK_NM, RECIPIENT_NM, SRC_SYS_ID, SRC_SYS_TRAN_STYP, SRC_SYS_TRAN_TYP, TXN_TYP}
import constants.TableColumnName.CP_STAGING_COLN
import constants.{AccountIdTypeId, ProcessContext, TableColumnName}
import org.apache.spark.internal.Logging
import org.apache.spark.sql.{Column, DataFrame}
import implicits.TableToDfImplicits._
import implicits.ColumnImplicits.RenameColumn
import org.apache.spark.sql.functions.{col, lit}

object ProcessEbossHelper extends Logging {

  val SOURCE_COLN_FOR_INCOMING: Seq[String] = Seq(
    ORIG_NM, ORIG_ADDR, ORIG_BNK_ACCT,
    ORIG_BNK_NM, ORIG_BNK_ID, ORIG_BNK_ADDR,
    SRC_SYS_ID, ORIG_SYS_ID, CSP_BUS_DT, AML_TRANS_KEY
  )
  val SOURCE_COLN_FOR_OUTGOING: Seq[String] = Seq(
    RECIPIENT_NM, RECIPIENT_ADDR, RECIPIENT_BNK_ACCT,
    RECIPIENT_BNK_NM, RECIPIENT_BNK_ID, RECIPIENT_BNK_ADDR,
    SRC_SYS_ID, ORIG_SYS_ID, CSP_BUS_DT, AML_TRANS_KEY
  )

  val RENAME_COLN_NAME_FOR_INCOMING: Map[String, String] = SOURCE_COLN_FOR_INCOMING.zip(CP_STAGING_COLN).toMap
  val RENAME_COLN_NAME_FOR_OUTGOING: Map[String, String] = SOURCE_COLN_FOR_OUTGOING.zip(CP_STAGING_COLN).toMap

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
      .select(SOURCE_COLN_FOR_INCOMING.map(col): _*)
      .columnRenamed(RENAME_COLN_NAME_FOR_INCOMING)
      .withColumn(TXN_TYP, lit(INCOMING))
    // filter outgoing transaction
    val ebossOutgoingDF = ebossDataFrame.filter(col(CR_DR_CD) === "O")
      .select(SOURCE_COLN_FOR_INCOMING.map(col): _*)
      .columnRenamed(RENAME_COLN_NAME_FOR_OUTGOING)
      .withColumn(TXN_TYP, lit(OUTGOING))
    ebossIncomingDF.union(ebossOutgoingDF)
  }

}
