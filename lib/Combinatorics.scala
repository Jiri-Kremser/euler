  class Combination(val num: Int) {
    final def !() = fact(num)
    @scala.annotation.tailrec
    final def fact(n: Int = num, acc: BigInt = 1): BigInt = {
      if (n == 0) acc else fact(n - 1, (acc * n))
    }

    def C(k: Int) = fact(num) / (fact(num - k) * fact(k))
  }

  implicit def intToCombination(num: Int) = new Combination(num)

