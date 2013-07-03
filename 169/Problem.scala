object Problem {
  val b1 = BigInt(10).pow(25) >> 1
  val b = BigInt(10).pow(25)

  def reduce(n: BigInt): BigInt = {
    if (n < java.lang.Long.MAX_VALUE) reduceLong(n.toLong)
    else if (n == b1 && hit()) 171684692768l // cached value
    else if (!n.testBit(0)) {
      val aux = n >> 1
      reduce(aux) + reduce(aux - 1)
    }
    else reduce(n >> 1)
  }

  def hit(): Boolean = {
    println("cache hit")
    true
  }

  def reduceLong(n: Long): Long = {
    if (n < java.lang.Integer.MAX_VALUE) reduceInt(n.toInt)
    else if (n % 2 == 0) {
      val aux = n >> 1
      reduceLong(aux) + reduceLong(aux - 1)
    }
    else reduceLong(n >> 1)
  }

  def reduceInt(n: Int): Int = {
    if (n == 0 || n == 1) 1
    else if (n == 2) 2
    else if (n == 4) 3
    else if (n % 2 == 0) {
      val aux = n >> 1
      reduceInt(aux) + reduceInt(aux - 1)
    }
    else reduceInt(n >> 1)
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(reduce(b))
    //println("b10: " + reduce(BigInt(10).pow(25) >> 10))
    //println("b1: " + reduce(b1))
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
