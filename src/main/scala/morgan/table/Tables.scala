package morgan.table

import TablesModel._
import morgan.utils.ImplicitFunctions.StringToTimestamp

object Tables {

  val cpMaster: Seq[CpMaster] = Seq(
    CpMaster("100000", "anish kumar", "patna, bihar", "", "11111", "1", "axis bank", "katira, ara", "eboss", "eboss", "2024-01-28"),
    CpMaster("100001", "manish kumar", "patna, bihar", "", "22222", "1", "axis bank", "katira, ara", "eboss", "eboss", "2024-01-28"),
    CpMaster("100002", "sarang chaudhari", "jalgaon, maharastra", "", "33333", "4", "hdfc bank", "m g road, jalgaon", "uswm", "uswm", "2024-01-31"),
    CpMaster("100003", "shobana dhanuskodi", "bangluru, karnatka", "", "44444", "3", "kotak mahindra bank", "m g road, bangluru", "etrade", "etrade", "2024-01-30")
  )

  val cpStagingDaily: Seq[CpStagingDaily] = Seq(
    CpStagingDaily("100004", "charushila patil", "mumbai, maharastra", "", "55555", "2", "state bank of india", "kalyan, mumbai", "rmbsa", "rmbsa", "2024-01-29"),
    CpStagingDaily("100005", "charu patil", "mumbai, maharastra", "", "66666", "2", "state bank of india", "kalyan, mumbai", "rmbsa", "rmbsa", "2024-01-29"),
    CpStagingDaily("100006", "sahil kumar", "nagpur, maharastra", "", "77777", "5", "icici bank", "m g road, nagpur", "uswm", "uswm", "2024-01-31")
  )

//  val cpSynonymList: Seq[CpSynonymList] = Seq(
//    CpSynonymList("1", "banglore", "bangluru", "2025-01-28".toTimestamp, "2025-01-01".toTimestamp, "2025-12-31".toTimestamp, "eboss", "eboss", "2024-01-28"),
//    CpSynonymList("2", "Bombay", "mumbai", "2025-01-28".toTimestamp, "2025-01-01".toTimestamp, "2025-12-31".toTimestamp, "rmbsa", "rmbsa", "2024-01-29")
//  )

//  val cpNoiseWordList: Seq[CpNoiseWordList] = Seq(
//    CpNoiseWordList("1", "Mr.", "2025-01-28".toTimestamp, "2025-01-01".toTimestamp, "2025-12-31".toTimestamp, "2024-01-28"),
//    CpNoiseWordList("2", "Mrs.", "2025-01-28".toTimestamp, "2025-01-01".toTimestamp, "2025-12-31".toTimestamp, "2024-01-28")
//  )

  val cpLinkage: Seq[CpLinkage] = Seq(
    CpLinkage(100000, 111111, "event_id", "status_ind", "2024-01-28", "link_flag", "2024-01-28", "2024-01-28"),
    CpLinkage(100001, 111111, "event_id", "status_ind", "2024-01-28", "link_flag", "2024-01-28", "2024-01-28")
  )

  val cpLinkageDaily: Seq[CpLinkageDaily] = Seq(
    CpLinkageDaily(100004, 222222, "event_id", "status_ind", "2024-01-28"),
    CpLinkageDaily(100005, 222222, "event_id", "status_ind", "2024-01-28")
  )

}
