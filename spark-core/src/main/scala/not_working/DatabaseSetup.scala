package not_working

import slick.jdbc.H2Profile.api._

import scala.concurrent.{ExecutionContext, Future}

object DatabaseSetup {
  // Define your database schema
  private val schema = Seq[DBIO[_]](
    // Set the default schema
    sqlu"SET SCHEMA PUBLIC",

    // Create schema and tables
    sqlu"CREATE SCHEMA IF NOT EXISTS MORGAN",

    sqlu"SET SCHEMA MORGAN",

    sqlu"""
      CREATE TABLE IF NOT EXISTS USERS (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        email VARCHAR(255) NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        CONSTRAINT users_email_unique UNIQUE (email)
      )
    """,

    // Insert initial data
    sqlu"""
      MERGE INTO USERS (name, email)
      KEY(email)
      VALUES
        ('John Doe', 'john@example.com'),
        ('Jane Smith', 'jane@example.com')
    """
  )

  def initialize(db: Database)(implicit ec: ExecutionContext): Future[Unit] = {
    // Combine schema actions with logging
    val setupActions = schema.zipWithIndex.map { case (action, index) =>
      action.map { result =>
        println(s"Completed step ${index + 1}/${schema.length}")
        result
      }
    }

    // Combine all actions into a single transactional operation
    val setup = DBIO.sequence(setupActions).transactionally

    // Run the combined action
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

