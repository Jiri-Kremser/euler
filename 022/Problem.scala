object Problem {
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(scala.io.Source.fromFile("names.txt").mkString.replaceAll("\"","").split(",").toList.sorted.sorted.zip(1 to 5163).map(x => x._2 * (x._1.map(c => c-'@').sum)).sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
