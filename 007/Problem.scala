object Problem {
  def sieveOfEratosthenes(n: Int) = {
    val primes = new scala.collection.mutable.BitSet(n)
    primes ++= (2 to n)
    val sqrt = Math.sqrt(n).toInt
    for {
      candidate <- 2 to sqrt
      if primes contains candidate
    } primes --= candidate * candidate to n by candidate
    primes
  }

  def main(args: Array[String]) {
    println(sieveOfEratosthenes(999999).toList(10000))
  }
}

