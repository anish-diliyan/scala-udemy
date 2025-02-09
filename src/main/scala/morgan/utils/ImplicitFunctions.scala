package morgan.utils


import org.apache.spark.sql.DataFrame
import java.sql.Timestamp
import java.text.SimpleDateFormat

object ImplicitFunctions {

  implicit class StringToTimestamp(val str: String) extends AnyVal {
    def toTimestamp: Timestamp = {
      val dateFormat = new SimpleDateFormat("yyyy-MM-dd")
      val parsedDate = dateFormat.parse(str)
      new Timestamp(parsedDate.getTime)
    }
  }

  implicit class RenameColumns(df: DataFrame) {
    def renameColumn(renameMap: Map[String, String]): DataFrame = {
      renameMap.foldLeft(df)((df, rename) => df.withColumnRenamed(rename._1, rename._2))
    }
  }

}
