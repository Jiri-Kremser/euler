import scala.util.control.Breaks._

object Problem {

  def isPrime(num: Int): Boolean = {
    val ceiling = math.sqrt(num.toDouble).toInt
    (2 to ceiling) forall (x => num % x != 0)
  }

  def canBeWritten(num: Int): Boolean = {
    val twosqrs = for (i <- 1 to math.sqrt(num.toDouble / 2).toInt) yield i * i * 2
    for (i <- twosqrs) {
      if (isPrime(num - i)) return true
    }
    false
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    for (i <- 33 to Integer.MAX_VALUE by 2) {
      if (!isPrime(i) && !canBeWritten(i)) {
        println(i)
        val stop = System.currentTimeMillis
        println("Time taken: " + (stop - start) + "ms")
        break
      }
    }
  }
}
