object Problem {
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(Stream.from(0).map(x => x * x * x.toLong).take(10000).toList.groupBy(_.toString.sorted).filter(_._2.size == 5).map(_._2.head).min)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
