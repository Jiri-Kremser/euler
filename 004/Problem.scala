object Problem {
  def isPalindromic(n: Int): Boolean = {
    val nStr = n.toString
    nStr.length == 1 || nStr.take(nStr.length / 2).reverse == nStr.drop(nStr.length / 2 + (if (nStr.length % 2 == 0) 0 else 1))
  }

  def main(args: Array[String]) {
    println((for (x <- 100 to 999; y <- x to 999) yield x * y) filter isPalindromic max)
  }
}

