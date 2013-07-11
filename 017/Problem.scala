object Problem {
  val numbers1to20 = List("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                          "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
  val tens = List("twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

  def intToString(num: Int): String = {
    if (num == 1000) "onethousand"
    else if (num < 20) numbers1to20(num - 1)
    else if (num % 100 == 0) numbers1to20(num / 100 - 1) + "hundred"
    else if (num < 100) {
      if (num % 10 == 0) tens((num / 10) - 2)
      else tens((num / 10) - 2) + numbers1to20((num % 10) - 1)
    }
    else numbers1to20((num / 100) - 1) + "hundredand" + intToString(num % 100)
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((1 to 1000).map(intToString(_).length).sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
