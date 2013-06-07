object Problem {

  def sieveOfEratosthenes(n: Int) = {
    val primes = new scala.collection.mutable.BitSet(n)
    primes ++= (2 to n)
    val sqrt = scala.math.sqrt(n).toInt
    for {
      candidate <- 2 to sqrt
      if primes contains candidate
    } primes --= candidate * candidate to n by candidate
    primes
  }

  val primesUpToThousand = sieveOfEratosthenes(1000)

  def isPrime(num: Long): Boolean = {
    val ceiling = math.sqrt(num.toDouble).toInt
    num != 1 && num > 0 && ((2 to ceiling) forall (x => num % x != 0))
  }

  def testQuadraticFormula(a: Int, b: Int): Int = {
    Stream.from(0).takeWhile(n => isPrime(n * n + a * n + b)).length
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((for (a <- -1000 to 1000; b <- primesUpToThousand) yield ((a*b), testQuadraticFormula(a, b))).maxBy(_._2)._1)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
