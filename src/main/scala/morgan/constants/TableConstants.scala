package morgan.constants

object TableConstants {

  val COUNTERPARTY_ID: String = "counterparty_id"
  val CP_NAME = "cp_name"
  val CP_ADDRESS = "cp_address"
  val CP_COUNTRY_CODE = "cp_country_code"
  val CP_BANK_ACCT_NUM = "cp_bank_acct_num"
  val CP_BANK_ID = "cp_bank_id"
  val CP_BANK_NAME = "cp_bank_name"
  val CP_BANK_ADDRESS = "cp_bank_address"

  val SY_ID = "sy_id"
  val SYNONYM_NAME = "synonym_name"
  val SYNONYM_Value = "synonym_value"

  val NW_ID = "nw_id"
  val NOISE_WORD_DESC = "noise_word_desc"

  val ULTIMATE_COUNTERPARTY_ID = "ultimate_counterparty_id"
  val EVENT_ID = "event_id"
  val STATUS_IND = "status_ind"
  val LINK_FLAG = "link_flag"

  val INSERT_DATE = "insert_date"
  val CSP_RECORD_START_DT = "csp_record_start_dt"
  val CSP_RECORD_END_DT = "csp_record_end_dt"

  val CSP_SOURCE_SYSTEM = "csp_source_system"
  val CSP_SOURCE_ORIGIN = "csp_source_origin"
  val CSP_BUS_DT = "csp_bus_dt"

  val cpStagingDailyColn: List[String] = List(
    COUNTERPARTY_ID, CP_NAME, CP_ADDRESS, CP_COUNTRY_CODE, CP_BANK_ACCT_NUM, CP_BANK_ID, CP_BANK_NAME, CP_BANK_ADDRESS,
    CSP_SOURCE_SYSTEM, CSP_SOURCE_ORIGIN, CSP_BUS_DT
  )

}
