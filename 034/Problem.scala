import scala.annotation._

object Problem {
  @tailrec 
  def fact(n: Int, acc: BigInt = 1): BigInt = {
    if (n == 0) acc else fact(n - 1, (acc * n))
  }

  def isCurious(num: Int): Boolean = {
    num.toString.map(c => fact(c - '0')).sum == num
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((3 to 1000000).filter(isCurious).sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
