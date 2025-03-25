package source

import constants.NameConstants._

case class SourceModel(
  `ORIG_NM`: String = ORIG_NM,
  `ORIG_ADDR`: String = ORIG_ADDR,
  `ORIG_BNK_ACCT`: String = ORIG_BNK_ACCT,
  `ORIG_BNK_ID`: String = ORIG_BNK_ID,
  `ORIG_BNK_NM`: String = ORIG_BNK_NM,
  `ORIG_BNK_ADDR`: String = ORIG_BNK_ADDR,
  `RECIPIENT_NM`: String = RECIPIENT_NM,
  `RECIPIENT_ADDR`: String = RECIPIENT_ADDR,
  `FURTHER_RECIPIENT_BNK_ACCT`: String = FURTHER_RECIPIENT_BNK_ACCT,
  `RECIPIENT_BNK_ID`: String = RECIPIENT_BNK_ID,
  `RECIPIENT_BNK_NM`: String = RECIPIENT_BNK_NM,
  `RECIPIENT_BNK_ADDR`: String = RECIPIENT_BNK_ADDR,

  `CSP_BUS_DT`: String = CSP_BUS_DT,
  `AML_TRANS_KEY`: String = AML_TRANS_KEY,

  `ORIG_SYS_ID`: String = ORIG_SYS_ID,
  `SRC_SYS_ID`: String = SRC_SYS_ID,
  `SRC_SYS_TRAN_TYP`: String = SRC_SYS_TRAN_TYP,
  `SRC_SYS_TRAN_STYP`: String = SRC_SYS_TRAN_STYP,
  `AML_RGN_CD`: String = AML_RGN_CD,
  `CR_DR_CD`: String = CR_DR_CD

)
