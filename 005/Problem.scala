object Problem {
  def main(args: Array[String]) {
    println(1 to 300000000 filter(x => { (2 to 20).forall(y => x % y == 0) }))
  }
}

