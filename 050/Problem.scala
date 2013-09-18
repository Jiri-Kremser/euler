import scala.collection.mutable.{ListBuffer => MList}
import scala.collection.mutable.BitSet


object Problem {
  def isPrime(num: Int): Boolean = {
    val ceiling = math.sqrt(num.toDouble).toInt
    num > 0 && ((2 to ceiling) forall (x => num % x != 0))
  }

  def sieveOfEratosthenes(n: Int) = {
    val primes = BitSet(n)
    primes ++= (2 to n)
    val sqrt = scala.math.sqrt(n).toInt
    for {
      candidate <- 2 to sqrt
      if primes contains candidate
    } primes --= candidate * candidate to n by candidate
    primes
  }

  def findIt(): Int = {
    val primesLessThanMillion = sieveOfEratosthenes(10000).toList
    var cumulativeList = MList.empty ++= primesLessThanMillion
    for (i <- (1 until cumulativeList.length)) {
      cumulativeList(i) = cumulativeList(i - 1) + cumulativeList(i)
    }
    cumulativeList = cumulativeList filter (_ < 1000000)
    //cumulativeList.map(num => )
    // 535
    val baseline = cumulativeList.indexOf(cumulativeList.reverse.find(num => isPrime(num)).get)
    cumulativeList.drop(baseline).map(num => {
      val foo = cumulativeList.find(x => isPrime(num - x))
      foo match {
        case None => (num, 0)
        case Some(fooNum) => (num - fooNum, cumulativeList.indexOf(num) - cumulativeList.indexOf(fooNum))
      }
    }).maxBy(_._2)._1
  }
  
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(findIt())
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
