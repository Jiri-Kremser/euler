object SquareChains {

  def reduce(x: Long): Long = {
    def operation(x: Long): Long = {
      x.toString() map(x => java.lang.Long.valueOf(x - 48) * java.lang.Long.valueOf(x - 48)) sum
    }
    x match {
      case 1 => 0
      case 89 => 1
      case x => reduce(operation(x))
    }
  }

  def main(args: Array[String]) {
    println(1l to 9999999l map(reduce) sum)
  }
}
