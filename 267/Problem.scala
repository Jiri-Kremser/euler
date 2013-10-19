object Problem {

  class Combination(val num: Int) {
    final def !() = fact(num)
    @scala.annotation.tailrec
    final def fact(n: Int = num, acc: BigInt = 1): BigInt = {
      if (n == 0) acc else fact(n - 1, (acc * n))
    }

    def C(k: Int) = fact(num) / (fact(num - k) * fact(k))
  }

  implicit def intToCombination(num: Int) = new Combination(num)

  def game(num: Double, win: Boolean, f: Double) = if (win) num * (1 + 2 * f) else num * (1 - f)

  def foo(times: Int, wins: Int, f: Double) = {
    def foo0(times: Int, wins: Int, soFar: Double): Double = {
      if (times == 0) soFar else
      foo0(times -1, wins - 1, game(soFar, wins > 0, f))
    }
    foo0(times, wins, 1.0)
  }

// OBSERVATIONS:
// foo(1000, 432, 0.148) je max kdyz f == 0.148 => "alespon 432 vyher"
// melo by byt tedy ekvivalentni otazce: "jaka je pdst ze pri opakovanem (1000x) hodu minci, padne alespon 432x panna"
// takze suma [x e (432, 1000)] (1000 C x) * 0.5 ^ 1000

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    val coef = scala.math.pow(0.5, 1000)
    println((432 to 1000).map(x => (1000 C x).toDouble * coef).sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
