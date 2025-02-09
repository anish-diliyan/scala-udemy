package morgan.constants

import morgan.constants.SourceConstants._
import TableConstants.{CSP_BUS_DT, _}

object SourceToTableMapping {

  val cpStagingDailyColnNames: List[String] = List(
    CP_NAME, CP_ADDRESS, CP_BANK_ACCT_NUM, CP_BANK_ID, CP_BANK_NAME, CP_BANK_ADDRESS,
    CSP_SOURCE_SYSTEM, CSP_SOURCE_ORIGIN, CSP_BUS_DT, AML_TRANS_KEY
  )

  val incomingToCpStagingDaily: Map[String, String] = incomingNames.zip(cpStagingDailyColnNames).toMap

  val outgoingToCpStagingDaily: Map[String, String] = outgoingNames.zip(cpStagingDailyColnNames).toMap

}
