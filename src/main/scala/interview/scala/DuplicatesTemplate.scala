package interview.scala

object DuplicatesTemplate {

  def duplicates(list: List[Int]): Int = {
    // provide implementation for this function
    ???
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
