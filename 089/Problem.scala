object Problem {
  def saving(num: String): Int = {
    var sav = 0
    if (num.contains("VIIII")) sav += 3 // 9
    else if (num.contains("IIII")) sav += 2 // 4
    if (num.contains("LXXXX")) sav += 3 // 90
    else if (num.contains("XXXX")) sav += 2 // 40
    if (num.contains("DCCCC")) sav += 3 // 900
    else if (num.contains("CCCC")) sav += 2 // 400
    sav
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    val lines = scala.io.Source.fromFile("roman.txt").mkString.split("\n").toList
    println(lines map saving sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
