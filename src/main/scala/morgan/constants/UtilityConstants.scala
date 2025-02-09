package morgan.constants

import morgan.constants.TableConstants._

object UtilityConstants {

  val CSP_IS_OVERRIDEN = "csp_is_overriden"

  val ORIGINAL_COUNTERPARTY_ID = "original_counterparty_id"

  val columnsToClean: Seq[String] = Seq(CP_NAME, CP_ADDRESS, CP_BANK_ACCT_NUM, CP_BANK_ID, CP_BANK_NAME, CP_BANK_ADDRESS)

  val columnsToRemoveNoise: Seq[String] = Seq(CP_NAME, CP_ADDRESS, CP_BANK_ACCT_NUM, CP_BANK_ID, CP_BANK_NAME, CP_BANK_ADDRESS)
}
