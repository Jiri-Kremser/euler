object Problem {
  def isPandigital(num: Long): Boolean = {
    val size = num.toString.size
    size == num.toString.distinct.size && size == num.toString.max.toInt - '0'
  }

  def isPrime(num: Long): Boolean = {
    val ceiling = math.sqrt(num.toDouble).toInt
    num != 1 && num > 0 && ((2 to ceiling) forall (x => num % x != 0))
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println("7654321".permutations.map(x=> x.toLong).find(Problem.isPrime))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
