object Problem {
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(scala.io.Source.fromFile("numbers.txt").mkString.split("\n").map(BigInt(_)).sum.toString.take(10))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
