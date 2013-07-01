import scala.collection.mutable.{ListBuffer => MList}

object Problem{
  def findMaxPath(input: List[MList[Int]]) : Int = {
    for (i <- input.length - 2 to 0 by -1; j <- 0 to input(i).length - 1) 
      input(i)(j) += input(i + 1)(j) max input(i + 1)(j + 1)
    input(0)(0)
  }

  def main(args: Array[String]) {
    val triangle = scala.io.Source.fromFile("triangle.txt").mkString.split("\n").toList.map(x => MList.empty ++= (x.split(" ") map (_.toInt)))
    val start = System.currentTimeMillis
    println(findMaxPath(triangle))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
