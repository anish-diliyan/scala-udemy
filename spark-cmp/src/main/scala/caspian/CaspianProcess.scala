package caspian

import java.time.LocalDate


trait CaspianProcess {
  def run(ctx: CaspianContext, date: LocalDate, env: CaspianEnv, additionalArgs: Array[String]): Unit
}

