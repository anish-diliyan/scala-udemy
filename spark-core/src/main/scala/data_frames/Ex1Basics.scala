package data_frames

import common.SparkSessionBuilder
import common.DataFrameSchema.carsSchema

object Ex1Basics extends App {

  val spark = SparkSessionBuilder.createSession("data_frames.Ex1Basic")

  // reading a Json file as DataFrame
  val carsDF = spark.read.format("json").schema(carsSchema).load("spark-core/src/main/resources/data/cars.json")

  // print the dataframe
  carsDF.show()
  // print the schema of dataframe
  carsDF.printSchema()
  // You can think dataframe as a distributed collection of rows, that are confirming to the schema
  carsDF.take(2).foreach(println)

}
