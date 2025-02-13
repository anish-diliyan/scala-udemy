package tutorial.join

import jdk.internal.net.http.frame.DataFrame

object Example2LeftAnti extends App {

  private def createMatchKey(df: DataFrame): DataFrame = {
    df.withColumn(
      "match_key",
      F.concat_ws("||",
        matchingColumns.map(col =>
          F.when(
            F.col(col).isNull || F.trim(F.col(col)) === "",
            F.lit("")
          ).otherwise(F.trim(F.col(col)))
        ): _*
      )
    )
  }

  implicit class ExistingIdentification(private val transactionDF: DataFrame) {
    // Define matching columns
    private val matchingColumns = Seq(
      "cp_name",
      "cp_address",
      "cp_bank_name",
      "cp_bank_acct_num"
    )



    def removeExistingInStaging(stagingDf: DataFrame): DataFrame = {
      // Add match keys to both DataFrames
      val txnWithKey = createMatchKey(transactionDF)
      val stagingWithKey = createMatchKey(stagingDf)

      // Remove transactions that exist in staging
      val uniqueTransactions = txnWithKey
        .join(
          stagingWithKey.select("match_key"),
          Seq("match_key"),
          "left_anti"  // Keep only transactions that don't match with staging
        )
        .drop("match_key")  // Remove the match_key column

      uniqueTransactions
    }
  }

  // Usage
  val result = transactionDF.removeExistingInStaging(stagingDf)

}
