package interview.spark

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.{col, countDistinct}

object Question2Template {
  val spark: SparkSession = SparkSession
    .builder()
    .appName("Question2OrderedAllProducts")
    .config("spark.master", "local")
    .getOrCreate()

  val orders: Seq[(String, String)] = Seq(("1", "1"), ("1", "2"), ("1", "3"), ("2", "1"), ("2", "2"), ("3", "1"), ("3", "2"))
  val ordersDF: DataFrame = spark.createDataFrame(orders).toDF("customer_id", "product_id")

  val products: Seq[(String, String)] = Seq(("1", "product1"), ("2", "product2"), ("3", "product3"))
  val productsDF: DataFrame = spark.createDataFrame(products).toDF("product_id", "product_name")

  def customersWithAllProducts(orders: DataFrame, products: DataFrame): DataFrame = {
     ???
  }
  customersWithAllProducts(ordersDF, productsDF).show()
  /* implement customersWithAllProducts to get this output (customer who ordered all products)
   +-----------+-----------------+
   |customer_id|distinct_products|
   +-----------+-----------------+
   |          1|                3|
   +-----------+-----------------+
  */
}
