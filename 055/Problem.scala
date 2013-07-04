object Problem {
  def isPalindromic(num: BigInt): Boolean = {
    val nStr = num.toString
    nStr.length == 1 || nStr.take(nStr.length / 2).reverse == nStr.drop(nStr.length / 2 + (if (nStr.length % 2 == 0) 0 else 1))
  }

  def isLychrelCandidate(num: BigInt): Boolean = {
    def isLychrelCandidate(n: BigInt, iter: Int): Boolean = {
      if (iter == 0) true
      else {
        val candidate = n + BigInt(n.toString.reverse)
        if (isPalindromic(candidate)) false else isLychrelCandidate(candidate, iter - 1)
      }
    }
    isLychrelCandidate(num, 50)
  }
  
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println((1 until 10000).filter(x => isLychrelCandidate(BigInt(x))).length)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
