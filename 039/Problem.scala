object Problem {
  def findMaxForGivenPerimeter(p: Int): (Int, Int) = {
    (p, (for (c <- p / 3 to p / 2; a <- 1 until c; val b = p - c - a; if (a * a + b * b == c * c)) yield (a.toString + b.toString + c).sorted).distinct.length)
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((12 to 1000).map(findMaxForGivenPerimeter(_)).maxBy(_._2)._1)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
