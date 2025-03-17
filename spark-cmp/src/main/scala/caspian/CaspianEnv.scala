package caspian

sealed trait CaspianEnv

object CaspianEnv {
  case object DEV extends CaspianEnv
  case object QA extends CaspianEnv
  case object SANDBOX extends CaspianEnv
  case object PROD extends CaspianEnv
}

