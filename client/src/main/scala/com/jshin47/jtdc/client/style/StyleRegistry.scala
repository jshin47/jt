package com.jshin47.jtdc.client.style

import scalacss.Defaults._
import scalacss.ScalaCssReact._

object StyleRegistry {

  def load(): Unit = {
    ApplicationStyles.Z.addToDocument()
  }

}
