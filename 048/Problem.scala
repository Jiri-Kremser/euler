object Problem {
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((1 to 1000).map(x => BigInt(x).pow(x)).sum.toString.takeRight(10))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
