package playground

import org.apache.spark.sql.SparkSession

object JoinWithNull extends App {
  // Create SparkSession - the entry point to Spark SQL
  val spark = SparkSession.builder()
    .appName("JoinWithNull")
    .config("spark.master", "local")
    .getOrCreate()

  // Define case class for strong typing
  case class Person(id: Int, name: String, age: Option[Int])

  // Create DataFrames with better initialization
  val staging = spark.createDataFrame(Seq(
    Person(1, "A", Some(10)),
    Person(2, "B", None)
  ))

  val master = spark.createDataFrame(Seq.empty[Person])

  // Perform the join with column references
  private val joinCondition = staging.col("id") === master.col("id")

  // Cache the staging DataFrame if it's going to be used multiple times
  staging.cache()

  // Perform the join and show results
  staging.join(master, joinCondition, "left")
    .select(staging.col("*")) // Select only needed columns
    .show()

  // Clean up
  spark.stop()
}
