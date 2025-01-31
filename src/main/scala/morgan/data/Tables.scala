package morgan.data

import morgan.data.TablesModel._
import morgan.utils.ImplicitFunctions.StringToTimestamp

object Tables {

  val cpMaster: Seq[CpMaster] = Seq(
    CpMaster("100000", "anish kumar", "patna, bihar, india", "", "11111", "1", "axis bank", "katira, ara", "eboss", "eboss", "2024-01-28"),
    CpMaster("100001", "charushila patil", "mumbai, maharastra, india", "", "22222", "2", "state bank of india", "kalyan, mumbai", "rmbsa", "rmbsa", "2024-01-29"),
    CpMaster("100002", "shobana dhanuskodi", "bangluru, karnatka, india", "", "33333", "3", "kotak mahindra bank", "m g road, bangluru", "etrade", "etrade", "2024-01-30")
  )

  val cpStagingDaily: Seq[CpStagingDaily] = Seq(
    CpStagingDaily("100003", "sarang chaudhari", "jalgaon, maharastra, india", "", "44444", "4", "hdfc bank", "m g road, jalgaon", "uswm", "uswm", "2024-01-31"),
    CpStagingDaily("100004", "sahil kumar", "nagpur, maharastra, india", "", "55555", "5", "icici bank", "m g road, nagpur", "uswm", "uswm", "2024-01-31")
  )

  val cpSynonymList: Seq[CpSynonymList] = Seq(
    CpSynonymList("1", "banglore", "bangluru", "2025-01-28".toTimestamp, "2025-01-01".toTimestamp, "2025-12-31".toTimestamp, "eboss", "eboss", "2024-01-28"),
    CpSynonymList("2", "Bombay", "mumbai", "2025-01-28".toTimestamp, "2025-01-01".toTimestamp, "2025-12-31".toTimestamp, "rmbsa", "rmbsa", "2024-01-29")
  )

  val cpNoiseWordList: Seq[CpNoiseWordList] = Seq(
    CpNoiseWordList("1", "The", "2025-01-28".toTimestamp, "2025-01-01".toTimestamp, "2025-12-31".toTimestamp, "2024-01-28")
  )

  val cpLinkage: Seq[CpLinkage] = Seq(
    CpLinkage(100000, 100000, "event_id", "status_ind", "2024-01-28", "link_flag", "2024-01-28", "2024-01-28")
  )

  val cpLinkageDaily: Seq[CpLinkageDaily] = Seq(
    CpLinkageDaily(100000, 100000, "event_id", "status_ind", "2024-01-28")
  )

}
