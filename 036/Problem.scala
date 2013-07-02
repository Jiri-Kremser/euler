object Problem {
  def isPalindromic(nStr: String): Boolean = 
    nStr.length == 1 || nStr.take(nStr.length / 2).reverse == nStr.drop(nStr.length / 2 + (if (nStr.length % 2 == 0) 0 else 1))
  
  def toBinary(n: Int): List[Int] = if (n == 0) Nil else (n % 2).toInt :: toBinary(n / 2)
  
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((1 until 1000000).filter(x => isPalindromic(x.toString) && isPalindromic(toBinary(x).mkString)).sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
