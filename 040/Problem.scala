object Problem {
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    val champernownesConstant = 0 + (1 to 1000000).mkString
    println((0 to 6).map(x => champernownesConstant(scala.math.pow(10, x).toInt).toInt - '0').product)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
