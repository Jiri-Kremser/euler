object Problem {
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((BigInt(2).modPow(7830457, 10000000000l) * 28433 + 1).toString.takeRight(10))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
