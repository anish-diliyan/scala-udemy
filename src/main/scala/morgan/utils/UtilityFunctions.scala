package morgan.utils

import morgan.constants.TableConstants._
import morgan.constants.UtilityConstants.{CSP_IS_OVERRIDEN, ORIGINAL_COUNTERPARTY_ID}
import morgan.table.Tables.{cpLinkage, cpLinkageDaily, cpMaster, cpStagingDaily}
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.{coalesce, col, udf, when}
import org.apache.spark.sql.{DataFrame, SparkSession}

import java.util.regex.Pattern


object UtilityFunctions {

  def addCounterpartyId(transactionDF: DataFrame)(implicit spark: SparkSession): DataFrame = {
    val cpMasterDF = spark.createDataFrame(cpMaster)
    val cpStagingDailyDF = spark.createDataFrame(cpStagingDaily)

    val columnsToJoin = Seq(CP_NAME, CP_ADDRESS, CP_BANK_NAME, CP_BANK_ACCT_NUM)

    val masterJoinCondition = columnsToJoin.map(col => cpMasterDF(col) === transactionDF(col)).reduce(_ && _)
    val transactionWithMasterCpIdDF = transactionDF.join(cpMasterDF, masterJoinCondition, "left_outer")
      .select(transactionDF("*"), cpMasterDF(COUNTERPARTY_ID))

    val joinConditionStaging = columnsToJoin.map(col => cpStagingDailyDF(col) === transactionWithMasterCpIdDF(col)).reduce(_ && _)
    transactionWithMasterCpIdDF.join(cpStagingDailyDF, joinConditionStaging, "left_outer").select(
      transactionWithMasterCpIdDF.columns.map{ c =>
        if(c == COUNTERPARTY_ID) coalesce(transactionWithMasterCpIdDF(c), cpStagingDailyDF(c)).as(COUNTERPARTY_ID)
        else transactionWithMasterCpIdDF(c)
      }: _*
    )
  }

  def addUltimateCounterpartyIdV1(transactionDF: DataFrame)(implicit spark: SparkSession): DataFrame = {
    // Get the linkage data from cpLinkage or cp_LinkageDaily
    val cpLinkageDF = spark.createDataFrame(cpLinkage)
    val cpLinkageDailyDF = spark.createDataFrame(cpLinkageDaily)

    // Combine both linkage tables and select distinct mappings
    val combinedLinkageDF = cpLinkageDF
      .select(COUNTERPARTY_ID, ULTIMATE_COUNTERPARTY_ID)
      .union(cpLinkageDailyDF.select(COUNTERPARTY_ID, ULTIMATE_COUNTERPARTY_ID))
      .distinct()
      .filter(col(ULTIMATE_COUNTERPARTY_ID).isNotNull)  // Only keep records where ultimate_cp_id exists

    // Join with transaction DataFrame and update counterparty_id
    transactionDF
      // Store original counterparty_id for comparison
      .withColumn(ORIGINAL_COUNTERPARTY_ID, col(COUNTERPARTY_ID))
      .join(combinedLinkageDF,
        transactionDF(COUNTERPARTY_ID) === combinedLinkageDF(COUNTERPARTY_ID),
        "left")
      .withColumn(COUNTERPARTY_ID,
        when(col(ULTIMATE_COUNTERPARTY_ID).isNotNull, col(ULTIMATE_COUNTERPARTY_ID))
          .otherwise(transactionDF(COUNTERPARTY_ID)))
      .withColumn(CSP_IS_OVERRIDEN,
        when(col(COUNTERPARTY_ID) =!= col(ORIGINAL_COUNTERPARTY_ID), "Yes")
          .otherwise("No"))
      .drop(combinedLinkageDF(COUNTERPARTY_ID))  // Remove the joined column
      .drop(ULTIMATE_COUNTERPARTY_ID)  // Remove the ultimate_counterparty_id column
  }

  def addUltimateCounterpartyId(transactionDF: DataFrame)(implicit spark: SparkSession): DataFrame = {
    // Get the linkage data from cpLinkage or cp_LinkageDaily
    val cpLinkageDF = spark.createDataFrame(cpLinkage)
    val cpLinkageDailyDF = spark.createDataFrame(cpLinkageDaily)

    // Combine both linkage tables and select distinct mappings with renamed columns
    val combinedLinkageDF = cpLinkageDF
      .select(COUNTERPARTY_ID, ULTIMATE_COUNTERPARTY_ID)
      .union(cpLinkageDailyDF.select(COUNTERPARTY_ID, ULTIMATE_COUNTERPARTY_ID))
      .distinct()
      .filter(col(ULTIMATE_COUNTERPARTY_ID).isNotNull)
      .withColumnRenamed(COUNTERPARTY_ID, "linkage_" + COUNTERPARTY_ID)

    // Join with transaction DataFrame and update counterparty_id
    transactionDF
      // Store original counterparty_id for comparison
      .withColumn(ORIGINAL_COUNTERPARTY_ID, col(COUNTERPARTY_ID))
      .join(combinedLinkageDF,
        col(COUNTERPARTY_ID) === col("linkage_" + COUNTERPARTY_ID),
        "left")
      .withColumn(COUNTERPARTY_ID,
        when(col(ULTIMATE_COUNTERPARTY_ID).isNotNull, col(ULTIMATE_COUNTERPARTY_ID))
          .otherwise(col(COUNTERPARTY_ID)))
      .withColumn(CSP_IS_OVERRIDEN,
        when(col(COUNTERPARTY_ID) =!= col(ORIGINAL_COUNTERPARTY_ID), "Yes")
          .otherwise("No"))
      .drop("linkage_" + COUNTERPARTY_ID)  // Remove the joined column
      .drop(ULTIMATE_COUNTERPARTY_ID)  // Remove the ultimate_counterparty_id column
  }


}
