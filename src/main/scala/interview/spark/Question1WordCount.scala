package interview.spark

import org.apache.spark.sql.{Dataset, Row, SparkSession}
import org.apache.spark.sql.functions._


object Question1WordCount {

  def wordCount(spark: SparkSession, input: Seq[String]): Dataset[Row] = {
    import spark.implicits._

    // create dataframe
    val df = input.toDF("value")

    val result = df.select(explode(split(lower($"value"), "\\s+")).as("word"))
      .filter($"word" =!= "")
      .groupBy($"word")
      .count()
      .orderBy($"count".desc)

    result
  }

  val spark: SparkSession = SparkSession.builder()
    .appName("Example1WordCount")
    .config("spark.master", "local")
    .getOrCreate()

  def main(args: Array[String]): Unit = {
    // call wordCount
    val input = Seq("Hello  world", "Hello   spark  world")
    val result = wordCount(spark, input)
    result.show()
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

}

