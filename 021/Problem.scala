object Problem {
  def properDivisors(num: Int) = {
    val firstHalf = (2 to math.sqrt(num.toDouble).toInt) filter (x => num % x == 0)
    firstHalf ++ firstHalf.map(num / _) :+ 1
  }

  def isAmicable(n: Int): Boolean = {
    val b = properDivisors(n).sum
    n != b && properDivisors(b).sum == n
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((1 until 10000).filter(isAmicable).sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
