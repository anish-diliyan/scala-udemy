package morgan.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat

object ImplicitFunctions {

  implicit class StringToTimestamp(val str: String) extends AnyVal {
    def toTimestamp: Timestamp = {
      val dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
      val parsedDate = dateFormat.parse(str)
      new Timestamp(parsedDate.getTime)
    }
  }

}
