package morgan.constants

object SourceConstants {

  val ORIG_NM = "orig_nm"
  val ORIG_ADDR = "orig_addr"
  val ORIG_BNK_ACCT = "orig_bnk_acct"
  val ORIG_BNK_ID = "orig_bnk_id"
  val ORIG_BNK_NM = "orig_bnk_nm"
  val ORIG_BNK_ADDR = "orig_bnk_addr"

  val RECIPIENT_NM = "recipient_nm"
  val RECIPIENT_ADDR = "recipient_addr"
  val RECIPIENT_ACCT_NUM = "recipient_acct_num"
  val RECIPIENT_BNK_ID = "recipient_bnk_id"
  val RECIPIENT_BNK_NM = "recipient_bnk_nm"
  val RECIPIENT_BNK_ADDR = "recipient_bnk_addr"

  val SRC_SYS_ID = "src_sys_id"
  val ORIG_SYS_ID = "orig_sys_id"
  val CSP_BUS_DT = "csp_bus_dt"
  val AML_TRANS_KEY = "aml_trans_key"

  val incomingNames: List[String] = List(
    ORIG_NM, ORIG_ADDR, ORIG_BNK_ACCT, ORIG_BNK_ID, ORIG_BNK_NM, ORIG_BNK_ADDR, SRC_SYS_ID, ORIG_SYS_ID, CSP_BUS_DT, AML_TRANS_KEY
  )

  val outgoingNames: List[String] = List(
    RECIPIENT_NM, RECIPIENT_ADDR, RECIPIENT_ACCT_NUM, RECIPIENT_BNK_ID, RECIPIENT_BNK_NM, RECIPIENT_BNK_ADDR, SRC_SYS_ID, ORIG_SYS_ID, CSP_BUS_DT, AML_TRANS_KEY
  )

}
