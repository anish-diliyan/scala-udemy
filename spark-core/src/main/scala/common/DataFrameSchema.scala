package common

import org.apache.spark.sql.types._

object DataFrameSchema {
  /*
     Spark Types: Spark defines case objects like LongType, StringType e.t.c to define the type of the data inside dataframe
     StructType: It is used to define schema of a DataFrame, by combining multiple
     StructField(name_of_coln, type, nullable = true/false) default value of nullable is true
   */
  val carsSchema: StructType = StructType(
    Array(
      StructField("Name", StringType),
      StructField("Mileage", IntegerType),
      StructField("Cylinders", IntegerType),
      StructField("Displacement", IntegerType),
      StructField("HorsePower", IntegerType),
      StructField("Weight_in_lbs", IntegerType),
      StructField("Acceleration", DoubleType),
      StructField("Year", StringType),
      StructField("Origin", StringType)
    )
  )

}
