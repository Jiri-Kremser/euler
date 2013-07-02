import scala.annotation._

object Problem {
  @tailrec
  def fact(n: Int, acc: BigInt = 1): BigInt = {
    if (n == 0) acc else fact(n - 1, (acc * n))
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((for (n <- 23 to 100; k <- 4 to (n / 2); if (fact(n)/(fact(k) * fact(n - k)) > 1000000)) yield if (k * 2 == n) 1 else 2).sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
