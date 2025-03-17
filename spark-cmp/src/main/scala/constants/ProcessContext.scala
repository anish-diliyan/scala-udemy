package constants

import caspian.CaspianContext

import java.time.LocalDate

case class ProcessContext(caspianContext: CaspianContext, cspBusDt: LocalDate, executionId: String)
