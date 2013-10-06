object Problem {
  def isPrime(num: Int): Boolean = {
    val ceiling = math.sqrt(num.toDouble).toInt
    num > 1 && ((2 to ceiling) forall (x => num % x != 0))
  }

  def allCombinations(num: Int): List[List[Int]] = {
    val inputMask = (0 until num.toString.size).toList
    (1 until inputMask.length).map(n => inputMask.combinations(n).toList).toList.flatten
  }

  def replace(num: Int, digit: Char, mask: List[Int]): Int = {
    num.toString.zipWithIndex.map(tupple => if (mask.contains(tupple._2)) digit else tupple._1).mkString.toInt
  }

  def numOfPrimesWithinTheFamily(num: Int): (Int, String) = {
    allCombinations(num).map(mask => (('0' to '9').map(digit => replace(num, digit, mask)).filter(x => x.toString.size == num.toString.size && isPrime(x)).size, mask.mkString)).toList.maxBy(_._1)
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    val theNumber = (96003 to 130000 by 2).find(numOfPrimesWithinTheFamily(_)._1 == 8).get
    //println(replace(theNumber._1, '1', theNumber._2.toList.map(_.toInt - '0')))
    println(theNumber)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
