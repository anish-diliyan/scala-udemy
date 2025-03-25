import caspian.{CaspianContext, CaspianEnv}
import transaction.TransactionProcess

import java.time.LocalDate

object RMBSATransactionProcess extends App {
  val process = new TransactionProcess()
  val context: CaspianContext = CaspianContext()
  val currentDate: LocalDate = LocalDate.now().minusDays(1) // yesterday's date
  val environment: CaspianEnv = CaspianEnv.DEV
  val arguments: Array[String] = Array(currentDate.toString, "executionId", "RMBSA")
  // Run the process
  process.run(ctx = context, date = currentDate, env = environment, additionalArgs = arguments)
}
