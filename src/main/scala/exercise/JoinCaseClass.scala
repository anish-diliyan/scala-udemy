package exercise

object JoinCaseClass extends App {
  class Source
  case class Incoming(orig_nm: String) extends Source
  case class Outgoing(recipient_nm: String) extends Source

  val incoming: Seq[Incoming] = Seq(Incoming("incoming"))
  val outgoing: Seq[Outgoing] = Seq(Outgoing("outgoing"))

  val sources: Seq[Source] = incoming ++ outgoing

  println(sources)
}
