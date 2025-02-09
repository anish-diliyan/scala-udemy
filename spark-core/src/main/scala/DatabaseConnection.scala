import slick.jdbc.PostgresProfile.api._
import com.typesafe.config.ConfigFactory
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object DatabaseConnection {
  private val config = ConfigFactory.load()

  val db = Database.forConfig("database.postgres")

  def initialize(): Unit = {
    try {
      Await.result(DatabaseSetup.initialize(db), 30.seconds)
    } catch {
      case e: Exception =>
        println(s"Failed to initialize database: ${e.getMessage}")
        e.printStackTrace()
        throw e
    }
  }

  def testConnection(): Unit = {
    try {
      val result = Await.result(
        db.run(sql"SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'".as[String]),
        5.seconds
      )
      println("Database connection successful!")
      println("Available tables:")
      result.foreach(tableName => println(s"  $tableName"))
    } catch {
      case e: Exception =>
        println(s"Database connection failed: ${e.getMessage}")
        e.printStackTrace()
        throw e
    }
  }
}

