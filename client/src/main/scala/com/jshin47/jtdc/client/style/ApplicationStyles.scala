package com.jshin47.jtdc.client.style

import scalacss.Defaults._
import scalacss.FontFace

object ApplicationStyles {

  object Z extends StyleSheet.Inline {
    import dsl._

    val zFontIsRoboto =
      fontFace(fontFamily = "Open Sans")(
        _.src(src = "url('https://fonts.googleapis.com/css?family=Open+Sans')")
      )
  }

}
