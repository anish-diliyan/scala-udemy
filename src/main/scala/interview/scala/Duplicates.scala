package interview.scala

import scala.annotation.tailrec

object Duplicates {

  def duplicates(list: List[Int]): Int = {
    @tailrec
    def naiveWithMemory(remainder: List[Int], occurrences: Map[Int, Int] = Map()): Int =
      if (remainder.isEmpty) occurrences.filter(_._2 == 1).head._1
      else {
        val currentNumber = remainder.head
        val currentOccurrences = occurrences.getOrElse(currentNumber, 0)

        naiveWithMemory(remainder.tail, occurrences + (currentNumber -> (currentOccurrences + 1)))
      }
    naiveWithMemory(list)
  }

  // all numbers in the list appear EXACTLY twice, EXCEPT one: find that number
  def main(args: Array[String]): Unit = {
    println(duplicates(List(1))) //1
    println(duplicates(List(1,2,1))) //2
    println(duplicates(List(1,2,3,2,1))) //3
    val first1000 = (1 to 100000).toList
    println(duplicates(first1000 ++ List(52369426) ++ first1000)) // 52369426
  }

}
