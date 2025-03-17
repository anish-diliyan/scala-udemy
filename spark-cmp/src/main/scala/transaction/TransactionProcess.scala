package transaction

import caspian.{CaspianContext, CaspianEnv, CaspianProcess}
import constants.{AccountIdTypeId, ProcessContext}
import constants.AccountIdTypeId.AccountIdTypeId
import transaction.helper.TransactionsReadHelper

import java.time.LocalDate

class TransactionProcess extends CaspianProcess {
  override def run(ctx: CaspianContext, date: LocalDate, env: CaspianEnv, additionalArgs: Array[String]): Unit = {
    println(s"Transaction Process started with env: $env , date: $date and additionalArgs: ${additionalArgs.mkString(", ")}")

    val executionId = additionalArgs(1)
    implicit val processContext: ProcessContext = ProcessContext(ctx, date, executionId)

    val sources: Seq[AccountIdTypeId] = additionalArgs(2).split(",").toSeq.map(AccountIdTypeId.withName)

    TransactionsReadHelper.processTransaction(sources)
  }
}
