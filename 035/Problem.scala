object Problem {

  def rotations(num: Int):List[Int] = {
    val s = num.toString
    for(i <- s.length until 0 by - 1 toList) yield (s.drop(i) + s.take(i)).toInt
  }

  def isPrime(num: Int): Boolean = {
    val ceiling = math.sqrt(num.toDouble).toInt
    (2 to ceiling) forall (x => num % x != 0)
  }

  def allRotationsArePrimes(num: Int): Int = if (rotations(num) forall isPrime) 1 else 0

  def main(args: Array[String]) {
    println(2 to 999999 map(allRotationsArePrimes) sum)
  }
}
