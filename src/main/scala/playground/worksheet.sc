val list1 = List("a", "b", "c", "d")
val list2 = List(1, 2, 3)
val result = list1.zip(list2).toMap
println(result)

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types._

case class Person(id: Int, name: String, age: Option[Int])

object JoinWithNull extends App {
  val staging = Seq[Person](
    Person(1, "A", Some(10)),
    Person(2, "B", None)
  ).toDF("id", "name", "age")
  val master = Seq[Person]().toDF("id", "name", "age")
  staging.join(master, staging("id") === master("id"), "left").show()
}