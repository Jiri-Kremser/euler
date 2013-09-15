import scala.collection.mutable.BitSet
import scala.collection.mutable.HashSet
import scala.annotation._

/*
20 000 000
C
15 000 000

=

20 000 000
C
 5 000 000

=

20 000 000 * 19 999 999 * 19 999 998 ... 15 000 001
---------------------------------------------------
5 000 000!

*/

object Problem {

  def factors(num: Long): List[Long] = {
    val ceiling = math.sqrt(num.toDouble).toInt
    val firstDividor = (2 to ceiling).find(x => num % x == 0)
    firstDividor match {
      case None => num :: Nil
      case Some(dividor) => dividor :: factors(num / dividor)
    }
  }
  
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(4l + ((15000001l until 20000000l).map(factors(_).sum).sum) - (2l until 5000000l).map(factors(_).sum).sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
