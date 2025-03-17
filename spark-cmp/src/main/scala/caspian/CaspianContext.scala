package caspian

import org.apache.spark.sql.SparkSession

class CaspianContext(spark: SparkSession) {
  def getSparkSession: SparkSession = spark
}

object CaspianContext {
  def apply(): CaspianContext = {
    val spark = SparkSession.builder()
      .appName("Complete ETL Pipeline")
      .config("spark.master", "local")
      .getOrCreate()
    new CaspianContext(spark)
  }
}
