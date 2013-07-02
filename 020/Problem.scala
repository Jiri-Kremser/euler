object Problem {
  def fact(n:Int):BigInt = if(n == 0) 1 else n * fact(n - 1)

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(fact(100).toString.map(x => x.toInt  - 48).sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
