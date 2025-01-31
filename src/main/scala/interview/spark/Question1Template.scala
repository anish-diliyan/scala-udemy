package interview.spark

import org.apache.spark.sql.{Dataset, Row, SparkSession}

object Question1Template extends App {

  val spark: SparkSession = SparkSession
    .builder()
    .appName("Example1WordCount")
    .config("spark.master", "local")
    .getOrCreate()

  val input = Seq("Hello  world", "Hello   spark  world")

  def wordCount(spark: SparkSession, input: Seq[String]): Dataset[Row] = {
    ???
  }
  wordCount(spark, input).show()
  /* Question: implement wordCount to get the following output, count should be in descending order
      +-----+-----+
      | word|count|
      +-----+-----+
      |hello|    2|
      |world|    2|
      |spark|    1|
      +-----+-----+
   */
}
