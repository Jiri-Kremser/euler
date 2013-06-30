object Problem {
  def main(args: Array[String]) {
    println(Math.pow(1 to 100 sum, 2).toInt - ((1 to 100).map(x => x * x) sum))
  }
}

