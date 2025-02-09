package not_working

import com.typesafe.config.ConfigFactory
import slick.jdbc.H2Profile.api._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object DatabaseConnection {
  private val config = ConfigFactory.load()

  val db = Database.forConfig("database.embedded")

  def initialize(): Unit = {
    try {
      Await.result(DatabaseSetup.initialize(db), 10.seconds)
    } catch {
      case e: Exception =>
        println(s"Failed to initialize database: ${e.getMessage}")
        e.printStackTrace()
        throw e
    }
  }

  def testConnection(): Unit = {
    try {
      val result = Await.result(db.run(sql"SELECT SCHEMA()".as[String]), 5.seconds)
      println(s"Database connection successful! Current schema: ${result.headOption.getOrElse("unknown")}")
    } catch {
      case e: Exception =>
        println(s"Database connection failed: ${e.getMessage}")
        e.printStackTrace()
        throw e
    }
  }
}
