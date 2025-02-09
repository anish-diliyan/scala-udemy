package morgan.utils

import org.apache.spark.sql.SparkSession

object ImplicitConstants {

  implicit val spark: SparkSession = SparkSession.builder()
    .appName("MorganExercise")
    .config("spark.master", "local")
    .getOrCreate()

}
