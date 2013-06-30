object Problem {

  def isUnusual(num: Int): Boolean = {
    def isPandigital(multiplicand: Int, multiplier: Int, product: Int): Boolean = {
      val numString = (multiplicand.toString + multiplier.toString + product.toString)
      !numString.contains('0') && numString.distinct.size == numString.size && ("123456789".toList -- numString.toList).isEmpty
    }
    val ceiling = math.sqrt(num.toDouble).toInt
    for (i <- 2 to ceiling) {
      if(num % i == 0 && isPandigital(num / i, i, num))  return true
    }
    false
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(2 to 9876 filter isUnusual sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
