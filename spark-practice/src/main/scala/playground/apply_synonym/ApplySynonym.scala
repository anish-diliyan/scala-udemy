package playground.apply_synonym

import java.util.regex.Pattern

case class Synonym(name: String, value: String)

object ApplySynonym extends App {

  def applySynonymV2(colValue: String, nameValues: List[Synonym]): (String, String) = {
    val (modifiedString, replacedValues) = colValue match {
      case value if value != null =>
        nameValues.foldLeft((value, Set.empty[String])) { case ((currentStr, replacedSet), synonym) =>
          // Use word boundary \b in regex to match whole words only
          val wordPattern = s"\\b${Pattern.quote(synonym.name)}\\b"
          if (currentStr.toLowerCase.matches(s".*\\b${Pattern.quote(synonym.name.toLowerCase)}\\b.*")) {
            (
              currentStr.replaceAll("(?i)" + wordPattern, synonym.value),
              replacedSet + synonym.name
            )
          } else {
            (currentStr, replacedSet)
          }
        }

      case _ => ("", Set.empty[String])
    }

    val synonymDescription = if (replacedValues.nonEmpty) {
      "Synonym: " + replacedValues.mkString(",")
    } else {
      "Synonym: none"
    }

    (modifiedString, synonymDescription)
  }

  val synonyms = List(Synonym("cat", "feline"), Synonym("Dog", "canine"))
  // Normal case
  val result = applySynonymV2("I have a Cat and a dog", synonyms)
  // Result: ("I have a feline and a canine", "Synonym: cat, dog")
  println(result)

  // Won't replace parts of words
  val result1 =applySynonymV2("I have a catalog and a dogma", synonyms)
  // Result: ("I have a catalog and a dogma", "Synonym: none")
  println(result1)

  // Empty string case
   val result2 = applySynonymV2("", synonyms)
  // Result: ("", "Synonym: none")
  println(result2)

  // Null case
  val result3 = applySynonymV2(null, synonyms)
  // Result: ("", "Synonym: none")
  println(result3)

  // No replacements case
  val result4 = applySynonymV2("I have a bird", synonyms)
  // Result: ("I have a bird", "Synonym: none")
  println(result4)
}
