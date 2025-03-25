package implicits

import constants.AccountIdTypeId._
import constants.NameConstants.CSP_BUS_DT
import constants.{AccountIdTypeId, ProcessContext}
import implicits.DateImplicits.CspDateString
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.col
import source.SourceData._

import java.time.LocalDate

object TableToDfImplicits {

  implicit class TransactionRead(ctx: ProcessContext) {
    val sparkSession: SparkSession = ctx.caspianContext.getSparkSession
    val cspBusDt: LocalDate = ctx.cspBusDt
    def getTransactions(source: AccountIdTypeId): DataFrame = {
      source match {
        case AccountIdTypeId.EBOSS => sparkSession.createDataFrame(eboss).filter(col(CSP_BUS_DT) === cspBusDt.toCspDateString)
        case AccountIdTypeId.RMBSA => sparkSession.createDataFrame(rmbsa).filter(col(CSP_BUS_DT) === cspBusDt.toCspDateString)
        case _ => throw new Exception("Invalid AccountIdTypeId")
      }
    }
  }

}
