object Problem {
  def divisorsNum(num: Int) = ((2 to math.sqrt(num.toDouble).toInt) filter (x => num % x == 0) length) * 2
  val triangleNumbers: Stream[Int] = Stream.from(0).map(n => if (n==0) 1 else triangleNumbers(n - 1) + n + 1)

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(triangleNumbers.find(divisorsNum(_) > 500))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
