package playground.add_cp_orig_nm

import constants.ImplicitConstants.spark
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

case class CounterParty(cp_id: Int, cp_name: String)

object AddCpOrigNm extends App {

  val schema = StructType(Array(
    StructField("cp_id", IntegerType, false),        // assuming cp_id is non-null string
    StructField("cp_orig_nm", StringType, true),    // assuming cp_orig_nm can be null
    StructField("mytime", TimestampType, false)     // timestamp column, non-null
  ))

  val counterparties: Seq[CounterParty] = Seq(
    CounterParty(1, "cp1"),
    CounterParty(2, "cp2")
  )

  val counterpartiesDF = spark.createDataFrame(counterparties)

  // Add another column cp_orig_nm in counterpartiesDF where value should be exact same as cp_name

  val updatedDF = counterpartiesDF.withColumn("cp_orig_nm", col("cp_name"))

  val dfWithFormattedTimestamp = updatedDF
    .withColumn("mytime", current_timestamp())  // This will create proper timestamp
    .withColumn("cp_orig_nm", col("cp_name"))

  val dfWithProperTimestamp = dfWithFormattedTimestamp
    .withColumn("mytime",
      to_timestamp(col("mytime"), "yyyy-MM-dd HH:mm:ss"))

  val validatedDF = spark.createDataFrame(
    dfWithProperTimestamp.rdd,
    schema
  )

  validatedDF.cache()

}
