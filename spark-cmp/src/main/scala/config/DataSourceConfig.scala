package config

import com.zaxxer.hikari.{HikariConfig, HikariDataSource}

import javax.sql.DataSource

object DataSourceConfig {
  def createDataSource(): DataSource = {
    val config = new HikariConfig()
    config.setJdbcUrl(sys.env.getOrElse("DB_URL", "jdbc:postgresql://localhost:5432/restr_transform_out_pp"))
    config.setUsername(sys.env.getOrElse("DB_USERNAME", "postgres"))
    config.setMaximumPoolSize(5)

    new HikariDataSource(config)
  }
}

