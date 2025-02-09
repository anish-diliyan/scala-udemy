package morgan.table

import java.sql.Timestamp

object TablesModel {
  case class CpMaster(
    counterparty_id: String,
    cp_name: String,
    cp_address: String,
    cp_country_cd: String,
    cp_bank_acct_num: String,
    cp_bank_id: String,
    cp_bank_name: String,
    cp_bank_address: String,
    csp_source_system: String,
    csp_source_origin: String,
    csp_bus_dt: String
  )
  case class CpStagingDaily(
    counterparty_id: String,
    cp_name: String,
    cp_address: String,
    cp_country_cd: String,
    cp_bank_acct_num: String,
    cp_bank_id: String,
    cp_bank_name: String,
    cp_bank_address: String,
    csp_source_system: String,
    csp_source_origin: String,
    csp_bus_dt: String
  )
  case class CpSynonymList(
    sy_id: String,
    synonym_name: String,
    synonym_value: String,
    insert_date: Timestamp,
    csp_record_start_dt: Timestamp,
    csp_record_end_dt: Timestamp,
    csp_source_system: String,
    csp_source_origin: String,
    csp_bus_dt: String
  )
  case class CpNoiseWordList(
    nw_id: String,
    noise_word_desc: String,
    insert_date: Timestamp,
    csp_record_start_dt: Timestamp,
    csp_record_end_dt: Timestamp,
    csp_bus_dt: String
  )
  case class CpLinkage(
    counterparty_id: Int,
    ultimate_counterparty_id: Int,
    event_id: String,
    status_ind: String,
    csp_bus_dt: String,
    link_flag: String,
    csp_record_start_dt: String,
    csp_record_end_dt: String
  )
  case class CpLinkageDaily(
    counterparty_id: Int,
    ultimate_counterparty_id: Int,
    event_id: String,
    status_ind: String,
    csp_bus_dt: String
  )
}
