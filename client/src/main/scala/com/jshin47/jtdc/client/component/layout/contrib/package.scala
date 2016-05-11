package com.jshin47.jtdc.client.component.layout

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Created by justin on 5/11/16.
  */
package object contrib {

  @js.native
  @JSName("Cellblock")
  object Cellblock extends js.Object {

    val Row: js.Dynamic                            = js.native
    val Column: js.Dynamic                         = js.native
    val Grid: js.Dynamic                           = js.native
    def observeGrid(t: js.Any): js.Dynamic         = js.native

  }

  @js.native
  @JSName("ReactSticky")
  object ReactSticky extends js.Object {

    val StickyContainer: js.Dynamic                 = js.native
    val Sticky:          js.Dynamic                 = js.native

  }

  @js.native
  @JSName("ReactDotDotDot")
  object ReactDotDotDot extends js.Object

  @js.native
  @JSName("ReactEqualizer")
  object ReactEqualizer extends js.Object

  @js.native
  @JSName("ReactCenter")
  object ReactCenter extends js.Object


}
