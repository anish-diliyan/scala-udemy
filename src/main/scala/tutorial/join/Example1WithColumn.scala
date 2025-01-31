package tutorial.join

import org.apache.spark.sql.SparkSession

case class Transaction(id: Int, name: String)
case class Linkage(id: Int, ultimateId: Int)


object Example1WithColumnDB {
 val transaction: Seq[Transaction] = Seq(
   Transaction(1, "John"),
   Transaction(2, "Mary"),
   Transaction(3, "Jack")
 )
  val linkage: Seq[Linkage] = Seq(
    Linkage(1, 100),
    Linkage(3, 300)
  )
}
object Example1WithColumn extends App {

  val spark = SparkSession.builder()
    .appName("Example1WithColumn")
    .config("spark.master", "local")
    .getOrCreate()

  val transactionDF = spark.createDataFrame(Example1WithColumnDB.transaction)
  val linkageDF = spark.createDataFrame(Example1WithColumnDB.linkage)

  //replace the id with ultimateId in transactionDF
  import org.apache.spark.sql.functions._    // for SQL functions
  import spark.implicits._                   // for $ notation

  val tempJoinedDF = transactionDF.join(linkageDF.select($"id".alias("link_id"), $"ultimateId"),
      $"id" === $"link_id",
      "left_outer").withColumn("id", coalesce($"ultimateId", $"id"))
    tempJoinedDF.show()
  /*+---+----+-------+----------+
    | id|name|link_id|ultimateId|
    +---+----+-------+----------+
    |  1|John|      1|       100|
    |  2|Mary|   NULL|      NULL|
    |  3|Jack|      3|       300|
    +---+----+-------+----------+
   */
  val joinedDF = tempJoinedDF.withColumn("id", coalesce($"ultimateId", $"id"))
    .drop("link_id", "ultimateId")
  /*
    +---+----+
    | id|name|
    +---+----+
    |100|John|
    |  2|Mary|
    |300|Jack|
    +---+----+
   */
  joinedDF.where($"id" === 2).select($"name").first().getString(0)
}
