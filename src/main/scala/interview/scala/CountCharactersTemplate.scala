package interview.scala

object CountCharactersTemplate extends App {

  def countCharacters(s: String): Map[Char, Int] = {
    ???
  }

  def testCountCharacters(): Unit = {
    println(countCharacters("Scala"))
    //Map(S -> 1, c -> 1, a -> 2, l -> 1)
    println(countCharacters("I love Scala and functional programming because it's awesome!"))
    //Map(e -> 5, s -> 3, n -> 4, t -> 2, ! -> 1, a -> 7, m -> 3,   -> 8, v -> 1, p -> 1, c -> 3, r -> 2, w -> 1, u -> 2, f -> 1, I -> 1, i -> 3, ' -> 1, b -> 1, g -> 2, l -> 3, o -> 4, S -> 1, d -> 1)
  }

  testCountCharacters()
}
