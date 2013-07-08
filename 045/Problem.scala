object Problem {
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    val limit = 130000
    println(((2 to limit).map(x => BigInt(x) * (3 * x - 1) / 2) intersect (2 to limit / 2).map(x => BigInt(x) * (2 * x - 1)))(1))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
