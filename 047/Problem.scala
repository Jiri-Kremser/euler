object Problem {

  //@scala.annotation.tailrec
  def factors(n : Int) : List[Int] = {
    def ld(n : Int) : Int = {
      def ldf(k : Int, n : Int) : Int = {
        if (n % k == 0) k
        else if (k * k > n) n
        else ldf(k + 1, n)
      }
      ldf(2, n)
    }

    n match {
      case 1 => Nil;
      case _ => {
        val p = ld(n)
        p :: factors(n / p)
      }
    }
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    val it = Stream.from(550).map(factors).iterator sliding 4
    var found = false
    while (it.hasNext && !found) {
      val values = it.next
      if (values.forall(_.distinct.size == 4)) { //&& (values(0) intersect values(1)).isEmpty && (values(0) intersect values(2)).isEmpty && (values(2) intersect values(1)).isEmpty) {
        found = true
        println(values.head.foldLeft(1)(_*_))
      }
    }
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
