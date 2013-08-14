import scala.collection.mutable.{ListBuffer => MList}

object Problem {

  def minPath(input: List[List[Int]]): Int = {
    def reduce(grid: List[List[Int]]): List[List[Int]] = {
      var itemList = List[(Int,Int)]()
      for (y <- 0 until grid.length; x <- 0 until grid(0).length) {
        if (grid(y)(x) != -1 && (x == 0 || grid(y)(x - 1) == -1) && (y == 0 || grid(y - 1)(x) == -1)) {
          itemList = (x, y) :: itemList
        }
      }
      if (itemList.length == 1) grid
      else {
        var auxList = grid
        for (i <- 0 until itemList.length - 1) {
          val (x1, y1) = itemList(i)
          val (x2, y2) = itemList(i + 1)
          val minOfTwo = grid(y1)(x1) min grid(y2)(x2)
          val y = y1 max y2
          val x = x1 max x2
          auxList = auxList.updated(y, auxList(y).updated(x, auxList(y)(x) + minOfTwo))
          if (i == itemList.length - 2) {
            if (x2 + 1 < auxList(0).length) auxList = auxList.updated(y2, auxList(y2).updated(x2 + 1, auxList(y2)(x2) + auxList(y2)(x2 + 1)))
            auxList = auxList.updated(y2, auxList(y2).updated(x2, -1))
          } else if (i == 0) {
            if (y1 + 1 < auxList.length) auxList = auxList.updated(y1 + 1, auxList(y1 + 1).updated(x1, auxList(y1)(x1) + auxList(y1 + 1)(x1)))
          }
          auxList = auxList.updated(y1, auxList(y1).updated(x1, -1))
        }
        reduce(auxList)
      }
    }
    var firstStep = input.updated(0, input(0).updated(1, input(0)(0) + input(0)(1)))
    firstStep = firstStep.updated(1, firstStep(1).updated(0, firstStep(0)(0) + firstStep(1)(0)))
    firstStep = firstStep.updated(0, firstStep(0).updated(0, -1))
    reduce(firstStep).last.last
  }

  def main(args: Array[String]) {
    val grid = scala.io.Source.fromFile("matrix.txt").mkString.split("\n").toList.map(_.split(",").toList.map(_.toInt))
    val start = System.currentTimeMillis
    println(minPath(grid))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
