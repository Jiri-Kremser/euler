object Problem {
  case class Hand(allCards: String) {
    val (royalFlush, straightFlush, fourOfAKind, fullHouse, flush, straight, threeOfAKind, twoPairs, onePair, highCard) = ("9","8", "7", "6", "5", "4", "3", "2", "1", "0")

    def rank: String = {
      val cards = allCards.split(" ")
      val colors = cards.map(_.tail)
      val numbers = cards.map(_.head).map(_ match {
        case 'T' => 10
        case 'J' => 11
        case 'Q' => 12
        case 'K' => 13
        case 'A' => 14
        case v => v.toInt - '0'
      })
      val sortedNums = numbers.sorted
      val valueProfile = numbers.groupBy(identity).map(x => (x._1, x._2.size))
      val maxTuple = valueProfile.maxBy(x => (x._2, x._1))
      
      def isStraight = numbers.distinct.size == numbers.size && (sortedNums.last - sortedNums.head == 4) || (sortedNums.last == 5 && sortedNums.head == 14 && sortedNums(1) == 2)
      def cardTail = '#' + sortedNums.reverse.map("%02d" format _).mkString

      if (colors.forall(_ == colors(0))) {
        if (isStraight) {
          if (numbers.min == 10) royalFlush else straightFlush + ("%02d" format numbers.min)
        } else flush + cardTail
      } else if (maxTuple._2 == 4) fourOfAKind + ("%02d" format maxTuple._1) + cardTail
      else if (maxTuple._2 == 3) {
        if (valueProfile.minBy(_._2)._2 == 2) fullHouse + cardTail else threeOfAKind + ("%02d" format maxTuple._1) + cardTail
      } else if (isStraight) straight + ("%02d" format numbers.min)
      else if (maxTuple._2 == 2) {
        if (valueProfile.size == 3) twoPairs + ("%02d" format maxTuple._1) + ((valueProfile.toList.sortBy(x => (x._2, x._1))).tail.head._1) + cardTail else onePair + ("%02d" format maxTuple._1) + cardTail
      }
      else highCard + cardTail
    }
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    val games = scala.io.Source.fromFile("poker.txt").mkString.split("\n").map(x => (x.substring(0, 14), x.substring(15)))
    println(games.filter(game => Hand(game._1).rank > Hand(game._2).rank).size)
    val stop = System.currentTimeMillis
    println("Time taken: " + (stop - start) + "ms")
  }
}
