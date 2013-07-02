object Problem {
  val diagNums: Stream[Int] = Stream.from(0).map(x => x match {
    case 0 => 1
    case n => ((((n - 1) / 4) + 1) * 2) + diagNums(n - 1)
  })

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(diagNums.takeWhile(_ <= 1001 * 1001).sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
