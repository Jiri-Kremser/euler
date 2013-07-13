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

  val primes = sieveOfEratosthenes(740000).drop(8)

  def isPrime(num: Int): Boolean = {
    val ceiling = math.sqrt(num.toDouble).toInt
    num != 1 && num > 0 && ((2 to ceiling) forall (x => num % x != 0))
  }

  def isTruncatable(num: Int): Boolean = {
    def ixes(nStr: String, fce: (String => String)): List[Int] = {
      nStr match {
        case "" => List.empty
        case str => str.toInt :: ixes(fce(str), fce)
      }
    }
    def suffixes(nStr: String): List[Int] = ixes(nStr, _.tail)
    def prefixes(nStr: String): List[Int] = ixes(nStr, _.init)
    prefixes(num.toString).forall(isPrime) && suffixes(num.toString).forall(isPrime)
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((for (n <- primes; if (isTruncatable(n))) yield n).sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
