package morgan.source

object SourceModel {

  case class Incoming(
    orig_nm: String,
    orig_addr: String,
    orig_bnk_acct: String,
    orig_bnk_id: String,
    orig_bnk_nm: String,
    orig_bnk_addr: String,
    src_sys_id: String,
    orig_sys_id: String,
    csp_bus_dt: String,
    aml_trans_key: String
  )

  case class Outgoing(
    recipient_nm: String,
    recipient_addr: String,
    recipient_acct_num: String,
    recipient_bnk_id: String,
    recipient_bnk_nm: String,
    recipient_bnk_addr: String,
    src_sys_id: String,
    orig_sys_id: String,
    csp_bus_dt: String,
    aml_trans_key: String
  )

}
