package transaction

import caspian.{CaspianContext, CaspianEnv, CaspianProcess}

import java.time.LocalDate

class TransactionProcess extends CaspianProcess {
  override def run(ctx: CaspianContext, date: LocalDate, env: CaspianEnv, additionalArgs: Array[String]): Unit = {
    println("Transaction process started" + " with" + ctx.getSparkSession.sparkContext.appName)
  }
}
