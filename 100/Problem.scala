/*
 "the math"

 x...#blue disks
 y...#total
 y > x

 (x*(x-1))/(y*(y-1) = 0.5
 2*(x*(x-1))/(y*(y-1) = 1
 2*(x*(x-1)) = (y*(y-1)
 2x^2 - 2x = y^2 - y

 http://www.wolframalpha.com/input/?i=2x%5E2+-+2x+%3D+y%5E2+-+y

 y = 1/2 (sqrt(8x^2 - 8x + 1) + 1)
 x = 1/2 (sqrt(2y^2 - 2y + 1) + 1)

 => find the first integer solution for y > 1e12
*/

object Problem {
  def isOk(num: BigInt) : Boolean = {
    val x = (scala.math.sqrt((2 * num.pow(2) - 2 * num + 1).doubleValue) + 1) / 2
    x == x.toInt
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(Range.BigInt(BigInt(1000000000000l), BigInt(1000000000000l + Int.MaxValue), 1) find isOk)
    // this is really slow, see the Python code for fast solution
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
