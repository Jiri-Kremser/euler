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

  val primes = sieveOfEratosthenes(100).toList.map(_.toInt)

  def countChange(money: Int, coins: List[Int]): Int = {
    def doit(money: Int, rest: List[Int]): Int = {
      if (rest.isEmpty) 0
      else if (money - rest.head == 0) 1 + doit(money, rest.tail)
      else if (money - rest.head > 0) doit(money - rest.head, rest) + doit(money, rest.tail)
      else doit(money, rest.tail)
    }

    doit(money, coins.sorted.reverse)
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((20 to 100).find(x => countChange(x, primes) > 5000))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
