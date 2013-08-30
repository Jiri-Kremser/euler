object Problem {
  def isPrime(num: Int): Boolean = {
    val ceiling = math.sqrt(num.toDouble).toInt
    num > 1 && ((2 to ceiling) forall (x => num % x != 0))
  }

  val diagNums: Stream[Int] = Stream.from(0).map(x => x match {
    case 0 => 1
    case n => ((((n - 1) / 4) + 1) * 2) + diagNums(n - 1)
  })

  def primesPercentageForSpiralSquareWithSideOfSize(n: Int): Double = {
    val numsToTest = diagNums.take(((n - 1) * 2) + 1)
    numsToTest.filter(isPrime).length.toDouble / numsToTest.length
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((26231 to 27001 by 2).find(primesPercentageForSpiralSquareWithSideOfSize(_) < .1))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
