package morgan

import morgan.data.DataModel.TransactionDF
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{lit, monotonically_increasing_id, row_number}

import scala.math.Integral.Implicits.infixIntegralOps

object GenerateAndAssign extends App {

  val spark = SparkSession.builder()
    .appName("Example1WithColumn")
    .config("spark.master", "local")
    .getOrCreate()

  def cpIdInSourceSystemDF(transactionDF: DataFrame) = {
    val cpMasterDF = ???
    val cpStagingDF = ???
    val cpLinkageDF = ???
    val cpLinkageDailyDF = ???

   ???
  }

//  val transaction = Seq(TransactionDF(1, "Anish"), TransactionDF(2, "Morgan"), TransactionDF(3, "Raj"))
//  // create dataframe for transaction
//  val transactionDF = spark.createDataFrame(transaction)

  def generateNewCpId(transactionDF: DataFrame, startingId: Int): DataFrame = {
    /*
      The current window specification Window.orderBy(lit(startingId)) is ordering by a constant value,
      which is inefficient and doesn't provide meaningful ordering. This could lead to non-deterministic results.
     */
    val windowSpec = Window.orderBy(lit(startingId))
    transactionDF.withColumn("cp_id", row_number().over(windowSpec) + startingId)
  }

  def generateNewCpIdV2(transactionDF: DataFrame, startingId: Int, numPartitions: Int = 200): DataFrame = {
    val dfWithMonoId = transactionDF
      .repartition(numPartitions)
      .withColumn("mono_id", monotonically_increasing_id())

    val windowSpec = Window.orderBy("mono_id")

    dfWithMonoId
      .withColumn("cp_id", row_number().over(windowSpec) + (startingId - 1))
      .drop("mono_id")
  }

  def generateNewCpIdV3(transactionDF: DataFrame, startingId: Int): DataFrame = {
    import spark.implicits._
    transactionDF.rdd
      .zipWithIndex
      .map { case (row, idx) => (row, idx + startingId) }
      .toDF()
  }
//  generateNewCpIdV3(transactionDF, 1000).show()

}
