object Problem {
  val fibs: Stream[BigInt] = 0 #:: 1 #:: ((fibs zip fibs.tail) map { case (c1,c2) => c1 + c2 })

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(fis.indexWhere(_.toString.length == 1000))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
