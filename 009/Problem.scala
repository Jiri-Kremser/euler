object Problem {
  def main(args: Array[String]) {
    println(for (a <- 100 to 400; b <- a to 500; c <- b to 600 if a+b+c == 1000 && a*a + b*b == c*c) yield (a*b*c))
  }
}

