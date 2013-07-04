object Problem {
  def canBeWrittenAsSumOfFifthPowers(num: Int): Boolean = 
    num.toString.map(x => scala.math.pow(x.toInt - '0', 5).toInt).sum == num
  
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((1000 until 400000).filter(canBeWrittenAsSumOfFifthPowers).sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
