package playground.remove_noise_words

object RemoveNoiseWords extends App {

  private def removeNoiseWords(colValue: String, noiseWords: Set[String]): String = {
    // Convert noise words to lowercase once
    val lowerNoiseWords = noiseWords.map(_.toLowerCase)

    Option(colValue) match {
      case None => colValue  // Return null if colValue is null
      case Some(s) => s
        .split("\\s+")                        // Split on whitespace
        .filterNot(word => lowerNoiseWords.contains(word.toLowerCase))  // Remove noise words
        .mkString(" ")                        // Join back with spaces
    }
  }


  val noiseWords = Set("The", "a", "an", "and", "or", "but", "in", "on", "at", "to", "for", "is", "are")

  // Test cases
  val testCases = List(
    "the cat and the dog",
    "",
    "the and or at",
    "cats dogs birds",
    "the   cat   and    dog",
    "The CAT and THE dog",
    "The cat, and the dog! Are in the garden.",
    "The 2 cats and 3 dogs are in the garden",
    "The cat-and-dog is in the garden",
    null,
    "TheAndBut"
  )

  // Run tests
  testCases.foreach { input =>
    println(s"Input: '$input'")
    println(s"Output: '${removeNoiseWords(input, noiseWords)}'")
    println("-" * 50)
  }
}
