object Problem {
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((for (a <- 2 until 100; b <- 3 until 100) yield BigInt(a).pow(b).toString.map(_.asDigit).sum).max)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
