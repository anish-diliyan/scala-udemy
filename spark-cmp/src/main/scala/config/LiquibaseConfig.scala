package config

import liquibase.Liquibase
import liquibase.database.DatabaseFactory
import liquibase.database.jvm.JdbcConnection
import liquibase.resource.ClassLoaderResourceAccessor
import org.slf4j.LoggerFactory
import javax.sql.DataSource
import scala.util.{Failure, Success, Try}

class LiquibaseConfig(dataSource: DataSource) {
  private val logger = LoggerFactory.getLogger(getClass)

  def migrate(): Unit = {
    logger.info("Starting database migration")
    var connection: java.sql.Connection = null

    Try {
      connection = dataSource.getConnection
      val database = DatabaseFactory.getInstance()
        .findCorrectDatabaseImplementation(new JdbcConnection(connection))

      val liquibase = new Liquibase(
        "db/changelog/db.changelog-master.yaml",
        new ClassLoaderResourceAccessor(),
        database
      )

      // Clear any locks that might have been left from a previous failed run
      liquibase.forceReleaseLocks()

      // Validate before updating
      liquibase.validate()

      // Run the update
      liquibase.update("")

    } match {
      case Success(_) =>
        logger.info("Database migration completed successfully")
      case Failure(exception) =>
        logger.error("Database migration failed", exception)
        throw exception
    }
  }
}
