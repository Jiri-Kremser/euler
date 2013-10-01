object Problem {
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    var secret = scala.io.Source.fromFile("cipher1.txt").mkString.split(",").toList.map(_.trim.toInt)
    println((for (c1 <- ('a' to 'z'); c2 <- ('a' to 'z'); c3 <- ('a' to 'z')) yield secret.grouped(3).toList.dropRight(1).map(x => "" + ((x(0) ^ c1).toChar) + ((x(1) ^ c2).toChar) + ((x(2) ^ c3).toChar)).toList.flatten.mkString + (secret.last ^ c1).toChar).filter(text => text.contains("the") && text.forall(c => c <= 'z' && c >= ' '))(0).map(_.toInt).sum)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
