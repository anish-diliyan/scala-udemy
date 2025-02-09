package morgan.source

import morgan.source.SourceModel.{Incoming, Outgoing}

object Source {
  val incoming: Seq[Incoming] = Seq(
    Incoming("anish kumar", "patna, bihar", "11111", "1", "axis bank", "katira, ara", "eboss", "eboss", "2025-01-28", "121"),
    Incoming("manish kumar", "patna, bihar", "22222", "1", "axis bank", "katira, ara", "eboss", "eboss", "2025-01-28", "122"),
    Incoming("ramanDeep kaur", "mohali, punjab", "88888", "1", "axis bank", "m g road, mohali", "eboss", "eboss", "2025-01-28", "123")
  )
  val outgoing: Seq[Outgoing] = Seq(
    Outgoing("charushila patil", "mumbai, maharastra", "55555", "2", "state bank of india", "kalyan, mumbai", "rmbsa", "rmbsa", "2025-01-29", "124"),
    Outgoing("charu patil", "mumbai, maharastra", "66666", "2", "state bank of india", "kalyan, mumbai", "rmbsa", "rmbsa", "2025-01-29", "125")
  )
}
