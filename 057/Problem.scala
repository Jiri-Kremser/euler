object Problem {

  case class Frac(val a: BigInt, val b : BigInt = 1) {
    def /(other: Frac): Frac = Frac(a * other.b, b * other.a).normalize
    def /(other: BigInt): Frac = this / Frac(other).normalize

    def *(other: Frac): Frac = Frac(a * other.a, b * other.b).normalize
    def *(other: BigInt): Frac = this * Frac(other).normalize

    def +(other: Frac): Frac = Frac(a * other.b + b * other.a, b * other.b).normalize
    def +(other: BigInt): Frac = this + Frac(other).normalize

    def normalize = {
      @scala.annotation.tailrec
      def gcd(a: BigInt, b: BigInt): BigInt = {
        b match {
          case v: BigInt if v == 0 => a
          case _ => gcd(b, (a % b))
        }
      }      
      val gcdVal = gcd(a, b)
      Frac(a / gcdVal, b / gcdVal)
    }
    
    override def toString = a + "/" + b
  }
  implicit def Int2FractionInt(value : BigInt) = Frac(value, value)

  def isOk(foo: Frac): Boolean = foo.a.toString.length > foo.b.toString.length

  /*
a_0 = 1 + 1/2
a_n+1 = 1 + 1/(2 + a_n)
*/
  var last: Frac = Frac(41, 29)
  def next = {
    last = BigInt(1) + (BigInt(1) / (BigInt(2) + last))
    last
  }

  ((5 to 1000) map (x => next) filter isOk).length

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(((5 to 1000) map (x => next) filter isOk).length)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }  
}

