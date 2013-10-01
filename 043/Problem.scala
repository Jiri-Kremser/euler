object Problem {
  def hasTheProperty(num: String): Boolean = {
    val primes = List(2, 3, 5, 7, 11, 13, 17)
    (1 to 7).forall(n => num.substring(n, n + 3).toInt % primes(n - 1) == 0)
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println("1234567890".permutations.filter(hasTheProperty).map(_.toLong).sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
