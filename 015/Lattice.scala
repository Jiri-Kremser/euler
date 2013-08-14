object Lattice {
  def paths(x: Long, y: Long ): Long = {
      (x, y) match {
        case (1, y) => y + 1
        case (x, 1) => x + 1
        case (x, y) => paths(x - 1, y) + paths(x, y - 1)
      }
  }

  def main(args: Array[String]) {
    println(paths(20, 20))
  }
}
