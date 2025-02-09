import java.sql.Timestamp
import java.text.SimpleDateFormat

def toTimestamp(str: String): Timestamp = {
  val dateFormat = new SimpleDateFormat("yyyy-MM-dd")
  val parsedDate = dateFormat.parse(str)
  new Timestamp(parsedDate.getTime)
}

val result = toTimestamp("2018-01-01")

println(result)