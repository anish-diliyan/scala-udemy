import caspian.{CaspianContext, CaspianEnv}
import transaction.TransactionProcess

import java.time.LocalDate

object TransactionProcess extends App {
    val process = new TransactionProcess()
    val context = CaspianContext()
    val currentDate = LocalDate.now().minusDays(1) // yesterday's date
    val environment = CaspianEnv.DEV
    val arguments = Array(currentDate.toString, "executionId", "EBOSS,RMBSA") // empty arguments array
    // Run the process
    process.run(ctx = context, date = currentDate, env = environment, additionalArgs = arguments)
}

