object Problem {

  class SudokuBoard(val data:Array[Array[Int]]) {
    def row(row: Int) = data(row)
    def col(col: Int) = data.map(_(col))
    def square(sq: Int) = {
      val cc = sq % 3;
      var rr = sq / 3;
      data.slice(rr * 3, rr * 3 + 3).map(_.slice(cc * 3, cc * 3 + 3)).reduce(_ ++ _)
    }

    def isValid() = {
      def isValid(select: Int => Seq[Int]): Boolean = {
        (0 until 9).forall(n => {
          val withoutZeros = select(n).filter(_ != 0)
          withoutZeros.size == withoutZeros.distinct.size
        })
      }
      isValid(row) && isValid(col) && isValid(square)
    }

    def updated(row: Int, col: Int, value: Int) = {
        var newData = data.updated(row, data(row).updated(col, value))
        new SudokuBoard(newData);
    }

    def findUpperLeftMostZero(): (Int, Int) = {
      val pos = data.flatten.indexOf(0)
      if (pos != -1) (pos / 9, pos % 9) else (-1, -1)
    }

    override def toString = {
      data.map("\n" + _.zipWithIndex.map(x => (if (x._2 % 3 == 0) "| " else " ") + x._1).mkString).zipWithIndex.map(x => if (x._2 % 3 == 0) "\n" + "-" * 21 + x._1 else x._1).mkString + "\n"
    }
 }

  def solve(sudoku: SudokuBoard): Option[SudokuBoard] = {
    val (row, col) = sudoku.findUpperLeftMostZero
    val noMoreZeros = row == -1 && col == -1
    if (!sudoku.isValid) None
    else if (noMoreZeros) Some(sudoku) // we are done
    else (1 to 9).map(n => {
      solve(sudoku.updated(row, col, n))
    }).find(_.nonEmpty) getOrElse None
  }

  def parse(path: String): List[SudokuBoard] = {
    scala.io.Source.fromFile(path).mkString.split("\n").zipWithIndex.filter(_._2 % 10 != 0).map(x => x._1.toArray.map(_.toString.toInt)).grouped(9).toList.map(new SudokuBoard(_))
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    val sudokus = parse("sudoku.txt")
    val solvedSudokus = sudokus.map(solve)
    // just assure everything is ok
    assert(solvedSudokus.forall(_.nonEmpty) == true)
    println(solvedSudokus.map(_.get.row(0).take(3).mkString.toInt).sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
