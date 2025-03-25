package implicits

import utils.CalendarUtils

import java.time.LocalDate

object DateImplicits {
   implicit class CspDateString(date: LocalDate) {
      def toCspDateString: String = CalendarUtils.parseDateToString(date)
   }
}
