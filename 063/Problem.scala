object Problem {
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((for (base <- 1 to 9; exponent <- 1 to 30; if (BigInt(base).pow(exponent).toString.length == exponent)) yield (base, exponent)).length)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
