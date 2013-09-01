object Problem {
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((for (a <- 2 to 100; b <-2 to 100) yield BigInt(a).pow(b)).distinct.size)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
