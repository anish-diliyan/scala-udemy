import slick.jdbc.PostgresProfile.api._
import scala.concurrent.{ExecutionContext, Future}
import scala.io.Source
import java.nio.file.{Paths, Files}
import java.nio.charset.StandardCharsets

object DatabaseSetup {
  def loadSqlFile(path: String): String = {
    val source = Source.fromFile(path)
    try source.mkString finally source.close()
  }

  def initialize(db: Database)(implicit ec: ExecutionContext): Future[Unit] = {
    val sqlPath = "sql/employees_db.sql"

    if (!Files.exists(Paths.get(sqlPath))) {
      Future.failed(new Exception(s"SQL file not found: $sqlPath"))
    } else {
      val sqlContent = loadSqlFile(sqlPath)

      // Split SQL content into individual statements
      val statements = sqlContent
        .split(";")
        .map(_.trim)
        .filter(_.nonEmpty)
        .map(stmt => sqlu"#$stmt")

      // Execute statements sequentially
      val setup = DBIO.sequence(statements.toSeq).transactionally

      db.run(setup)
        .map(_ => println("Database initialized successfully"))
        .recover {
          case ex: Exception =>
            println(s"Database initialization failed: ${ex.getMessage}")
            ex.printStackTrace()
            throw ex
        }
    }
  }
}

