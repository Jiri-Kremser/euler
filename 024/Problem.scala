object Problem {
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((0 to 9).permutations.drop(999999).take(1).toList(0).mkString)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
