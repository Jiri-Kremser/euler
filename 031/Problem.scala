object Problem {
  def countChange(money: Int, coins: List[Int]): Int = {
    def doit(money: Int, rest: List[Int]): Int = {
      if (rest.isEmpty) 0
      else if (money - rest.head == 0) 1 + doit(money, rest.tail)
      else if (money - rest.head > 0) doit(money - rest.head, rest) + doit(money, rest.tail)
      else doit(money, rest.tail)
    }

    doit(money, coins.sorted.reverse)
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(countChange(200, List(1,2,5,10,20,50,100,200)))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
