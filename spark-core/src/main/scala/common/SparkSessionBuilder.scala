package common

import org.apache.spark.sql.SparkSession

object SparkSessionBuilder {

  def createSession(appName: String): SparkSession = {
    SparkSession
      .builder()
      .appName(appName)
      .config("spark.master", "local")
      .getOrCreate()
  }

}
