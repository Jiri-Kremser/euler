import Array._

object Problem {
  
  def findMaxPeriod(): Int = {
    var sequenceLength = 0; var max = 0

    for (i <- 1000 to 0 by -1) {
      if (sequenceLength > i) {
        return max
      }
      var remainders = ofDim[Int](i); var value = 1; var pos = 0
      while (remainders(value) == 0 && value != 0) {
        remainders(value) = pos
        pos += 1
        value *= 10
        value %= i
      }
      if (pos - remainders(value) > sequenceLength) {
        sequenceLength = pos - remainders(value)
        max = i
      }
    }
    -1
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    println(findMaxPeriod())
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
