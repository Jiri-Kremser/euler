object Problem {
  def properDivisors(num: Int) = (1 until num) filter (x => num % x == 0)
  def isAbundant(num: Int) = properDivisors(num).sum > num

  def main(args: Array[String]) {
    val start = System.currentTimeMillis

    val abundantSums = {
      val abundantNumbers = (12 to 28123).filter(isAbundant)
      val sumOfAbundant = new scala.collection.mutable.BitSet(27000)
      for (first <- abundantNumbers; second <- abundantNumbers; if (first + second <= 28123)) {
        sumOfAbundant += first + second
      }
      sumOfAbundant
    }
    println((1 to 28123).sum - abundantSums.toList.sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
