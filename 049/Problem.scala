object Problem {
  def sieveOfEratosthenes(n: Int) = {
    val primes = new scala.collection.mutable.BitSet(n)
    primes ++= (2 to n)
    val sqrt = scala.math.sqrt(n).toInt
    for {
      candidate <- 2 to sqrt
      if primes contains candidate
    } primes --= candidate * candidate to n by candidate
    primes
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    val fourDigitPrimes = sieveOfEratosthenes(9997).filter(_ > 1000).toList
    /* all 4-digit arithmetic sequences of primes */
    val result = for (p <- fourDigitPrimes; 
                      secondIndex <- fourDigitPrimes.indexOf(p) + 1 until fourDigitPrimes.length; 
                      val second = fourDigitPrimes(secondIndex);
                      val third = p + (second - p) * 2;
                      if (third < 9999 && fourDigitPrimes.contains(third) && p != 1487 && 
                        p.toString.sorted == second.toString.sorted && p.toString.sorted == third.toString.sorted))
                      yield p + second.toString + third
    
    println(result(0))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }  
}

