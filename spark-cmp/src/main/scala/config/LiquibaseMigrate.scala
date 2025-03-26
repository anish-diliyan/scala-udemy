package config

import javax.sql.DataSource

class LiquibaseMigrate {
  val dataSource: DataSource = DataSourceConfig.createDataSource()
  val liquibaseConfig = new LiquibaseConfig(dataSource)

  try {
    liquibaseConfig.migrate()
  } catch {
    case e: Exception =>
      println(s"Failed to run migrations: ${e.getMessage}")
      System.exit(1)
  }
}
