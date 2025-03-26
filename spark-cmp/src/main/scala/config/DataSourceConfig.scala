package config

import com.zaxxer.hikari.{HikariConfig, HikariDataSource}

import javax.sql.DataSource

object DataSourceConfig {
  def createDataSource(): DataSource = {
    val config = new HikariConfig()
    // Read database configuration from liquibase.properties file
    val props = new java.util.Properties()
    props.load(getClass.getResourceAsStream("/db/liquibase.properties"))

    // Set database connection properties in config
    config.setDriverClassName(props.getProperty("driver"))
    config.setJdbcUrl(props.getProperty("url"))
    config.setUsername(props.getProperty("username"))
    config.setMaximumPoolSize(5)

    new HikariDataSource(config)
  }
}

