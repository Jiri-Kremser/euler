object Problem {
  def isOk(num: Int) : Boolean = {
    def toStrList(x: Int) = x.toString.toList.sorted
    val numStrList = toStrList(num)
    (2 to 6).forall(x => toStrList(num * x) == numStrList)
  }

  val powersOfTen: Stream[Int] = Stream.from(0).map(n => if (n==0) 10 else powersOfTen(n - 1) * 10)
  val validDomain: Stream[Int] = (for (i <- powersOfTen; j <- 10 * i to 16 * i) yield j).toStream

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(validDomain.find(isOk(_)))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
