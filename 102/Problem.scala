object Problem {
  case class Point(x: Int, y: Int)

  def isOriginInTriangle(triangle: (Point, Point, Point)) : Boolean = {
    def sign(p1: Point, p2: Point): Boolean = (p2.y * (p1.x - p2.x) - p2.x * (p1.y - p2.y)) < 0
    val aSideSign = sign(triangle._2, triangle._3)
    (sign(triangle._1, triangle._2) ==  aSideSign) && (aSideSign == sign(triangle._3, triangle._1))
  }

  val triangles = scala.io.Source.fromFile("triangles.txt").mkString.split("\n").map(x => {
      val coords = x.split(",").map(_.toInt);
      (Point(coords(0), coords(1)), Point(coords(2), coords(3)), Point(coords(4), coords(5))) })

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(triangles.filter(isOriginInTriangle).length)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
