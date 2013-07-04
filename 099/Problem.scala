import scala.math.log

object Problem {
  
  def comparator(a: (Int, Int), b: (Int, Int)) = a._2 / (log(b._1) / log(a._1)) > b._2

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(scala.io.Source.fromFile("base_exp.txt").mkString.split("\n").map(_.split(",")).map(x =>(x(0).toInt,x(1).toInt)).toList.zipWithIndex.sortWith((x,y) => comparator(x._1, y._1)).head._2 + 1)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
