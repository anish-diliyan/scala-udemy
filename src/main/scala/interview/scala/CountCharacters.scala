package interview.scala

import scala.annotation.tailrec

object CountCharacters {

  def countCharacters(s: String): Map[Char, Int] = {
//    @tailrec
//    def countCharactersTailrec(remaining: String, acc: Map[Char, Int]): Map[Char, Int] =
//      if (remaining.isEmpty) acc
//      else if (acc.contains(remaining.head)) {
//        val currentChar = remaining.head
//        val currentOccurrences = acc(currentChar)
//        countCharactersTailrec(remaining.tail, acc + (currentChar -> (currentOccurrences + 1)))
//      } else countCharactersTailrec(remaining.tail, acc + (remaining.head -> 1))
//    countCharactersTailrec(s, Map())
    // implement this using groupBy
    s.groupBy(identity).map(x => x._1 -> x._2.length)
  }

  def testCountCharacters(): Unit = {
    println(countCharacters("Scala"))
    //Map(S -> 1, c -> 1, a -> 2, l -> 1)
    println(countCharacters("I love Scala and functional programming because it's awesome!"))
    //HashMap(e -> 5, s -> 3, n -> 4, t -> 2, ! -> 1, a -> 7, m -> 3,   -> 8, v -> 1, p -> 1, c -> 3, r -> 2, w -> 1, u -> 2, f -> 1, I -> 1, i -> 3, ' -> 1, b -> 1, g -> 2, l -> 3, o -> 4, S -> 1, d -> 1)
  }

  def main(args: Array[String]): Unit = {
    testCountCharacters()
  }
}
