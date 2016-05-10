package com.jshin47.jtdc.client.component

import java.util.UUID

/**
  * Created by justin on 5/10/16.
  */
object ComponentUtilities {

  def generateKey: String = UUID.randomUUID().toString

}
