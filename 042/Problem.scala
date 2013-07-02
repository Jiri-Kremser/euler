object Problem {
  val triangleNumbers: Stream[Int] = Stream.from(0).map(n => if (n==0) 1 else triangleNumbers(n - 1) + n + 1)
  val first40Triangles = triangleNumbers.take(60).toList
  val words = scala.io.Source.fromFile("words.txt").mkString.split(",").toList.map(_.replaceAll("\"", ""))
  
  def isTriangleWord(word: String): Boolean = {
     first40Triangles.contains(word.toList.map(_-'@').sum)
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(words.filter(isTriangleWord).length)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
