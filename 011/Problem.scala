object Problem {
  val grid = scala.io.Source.fromFile("grid.txt").mkString.split("\n").toList.map(_.split(" ").toList.map(_.toInt))

  def findMaxProduct(grid: List[List[Int]]) : Long = {
      var maxProduct = 0
      for (y <- 0 until 20;
           x <- 0 until 20;
           val rowProduct = if (x > 16) 0 else  grid(x)(y) * grid(x + 1)(y) * grid(x + 2)(y) * grid(x + 3)(y);
           val columnProduct = if (y > 16) 0 else grid(x)(y) * grid(x)(y + 1) * grid(x)(y + 2) * grid(x)(y + 3);
           val diag1Product = if (y > 16 || x > 16) 0 else grid(x)(y) * grid(x + 1)(y + 1) * grid(x + 2)(y + 2) * grid(x + 3)(y + 3);
           val diag2Product = if (y > 16 || x < 3) 0 else grid(x)(y) * grid(x - 1)(y + 1) * grid(x - 2)(y + 2) * grid(x - 3)(y + 3)
      ) maxProduct = maxProduct max rowProduct max columnProduct max diag1Product max diag2Product
      maxProduct
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(findMaxProduct(grid))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
