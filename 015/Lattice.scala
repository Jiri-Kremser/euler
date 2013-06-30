object Lattice {
  def paths(x: Long): Long = {
    def paths0(x: Long, y: Long): Long = {
      (x, y) match {
        case (1, y) => y + 1
        case (x, 1) => x + 1
        case (x, y) => paths0(x - 1, y) + paths0(x, y - 1)
      }
    }
    paths0(x, x)
  }

  def main(args: Array[String]) {
    println(paths(20))
  }
}
