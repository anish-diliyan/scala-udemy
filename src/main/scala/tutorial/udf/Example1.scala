package tutorial.udf

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object Example1 extends App {
  val spark = SparkSession.builder()
    .appName("Example1")
    .config("spark.master", "local")
    .getOrCreate()

  // Create sample data
  import spark.implicits._
  val dataFrame = Seq("John", "Alice", "Bob", null).toDF("name")

  // Option(null) is None
  val upperCase = (value: String) => Option(value).map(_.toUpperCase)

  // Simple UDF to convert string to uppercase
  val upperCaseUDF = udf(upperCase)

  // Apply UDF
  val result = dataFrame.withColumn("upper_name", upperCaseUDF(col("name")))

  result.show()
  spark.stop()
}
