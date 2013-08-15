import java.util.{Calendar, GregorianCalendar}

object Problem {
  def isFirstDayOfMonthSunday(year: Int, month: Int): Boolean = {
    val calendar = new java.util.GregorianCalendar
    calendar.set(Calendar.YEAR, year)
    calendar.set(Calendar.MONTH, month)
    calendar.set(Calendar.DAY_OF_MONTH, 1)
    calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
  }  

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((for (year <- 1901 to 2000; month <- 0 to 11; if (isFirstDayOfMonthSunday(year, month))) yield (year, month + 1)).length)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
