package playground.unique_identification

import models.TablesModel._

object TablesData {

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

}
