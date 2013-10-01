object Problem {
  def isPentagonal(num: Int): Boolean = {
    val foo = (Math.sqrt(1 + 24 * num) + 1.0) / 6.0
    foo == foo.toInt
  }

  def pentagonal(n: Int): Int = n * (3 * n - 1) / 2

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    val pentagonalNumbers = (1 to 2500).map(pentagonal)
    def isOk(x: Int, index: Int): Boolean = isPentagonal(x - pentagonalNumbers(index)) && isPentagonal(x + pentagonalNumbers(index))
    val p_k = pentagonalNumbers.zipWithIndex.find(x => (x._2 - 1 to 0 by -1).exists(index => isOk(x._1, index))).get
    val p_j_index = (p_k._2 - 1 to 0 by -1).find(index => isOk(p_k._1, index)).get
    val p_j = (pentagonal(p_j_index + 1), p_j_index)
    println(p_k._1 - p_j._1)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
