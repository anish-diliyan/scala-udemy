package config

import javax.sql.DataSource

class LiquibaseMigrate {
  val dataSource: DataSource = DataSourceConfig.createDataSource()
  // This line is needed to create a LiquibaseConfig instance that will manage database migrations
  // Even with liquibase.properties file present, we need to explicitly create the config object
  // and pass the DataSource to it, as the properties file only contains static configuration
  // but doesn't handle the runtime database connection setup
  val liquibaseConfig = new LiquibaseConfig(dataSource)
  try {
    liquibaseConfig.migrate()
  } catch {
    case e: Exception =>
      println(s"Failed to run migrations: ${e.getMessage}")
      System.exit(1)
  }
}
