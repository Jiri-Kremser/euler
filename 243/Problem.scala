import scala.annotation._

// http://en.wikipedia.org/wiki/Euler's_totient_function
object Problem {

  def isPrime(num: Int): Boolean = {
    val ceiling = math.sqrt(num.toDouble).toInt
    num != 1 && num > 0 && ((2 to ceiling) forall (x => num % x != 0))
  }
  
  val primes = sieveOfEratosthenes(23)

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

 
  def gcd(a: Int, b: Int): Int = {
    @tailrec
    def gcd0(a: Int, b: Int): Int = {
      b match {
        case 0 => a
        case _ => gcd0(b, (a % b))
      }
    }
    if ((a % 2 == 0 && b % 2 == 0)) 1 else gcd0(a, b)
  }
  
  def isOk(num: Int): Boolean = {
    primes forall (num % _ != 0)
  }

  val primesUpToThousand = sieveOfEratosthenes(1000)
  
  def resilience(num: Int): Double = {
      var nominators = (1 until num by (if (num % 2 == 0) 2 else 1))

      (for (nominator <- nominators; if (gcd(num, nominator) == 1)) yield {
        1
      }).length / (num - 1).toDouble

      //(for (nominator <- 1 until num; if (isPrime(nominator) || gcd(num, nominator) == 1)) yield(1)).length / (num - 1).toDouble
  }

  //                        15499 / 94744 = 0.1635881955585578
  //   resilience(2*3*5*7*11*13*17*19*23) = 0.16358819608886738
  // resilience(2*3*5*7*11*13*17*19*23*2) = 0.16358819572223038
  // resilience(2*3*5*7*11*13*17*19*23*3) = 0.16358819560001805
  // resilience(2*3*5*7*11*13*17*19*23*5) = 0.16358819550224818
  // resilience(2*3*5*7*11*13*17*19*23*7) = 0.1635881954603468

  val candidates: Stream[Int] = Stream.from(1).map(_ * 36)

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    //val limit = 15499 / 94744.toDouble
    println(resilience(2*3*5*7*11*13*17*19*23*4))
    //println(candidates.find(resilience(_) < limit))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
