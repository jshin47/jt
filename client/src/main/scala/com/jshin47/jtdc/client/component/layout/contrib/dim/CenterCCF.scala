package com.jshin47.jtdc.client.component.layout.contrib.dim

import chandu0101.macros.tojs.JSMacro
import com.jshin47.jtdc.client.component.layout.contrib.Cellblock
import japgolly.scalajs.react.{React, ReactComponentU_, ReactNode}

import scala.scalajs.js

/**
  * Created by justin on 5/11/16.
  */
case class CenterCCF(
                      // LOOK MA, NO PROPS!
                    ) {

  def apply(children: ReactNode *) = {
    val props = JSMacro[CenterCCF](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Cellblock.Grid)
    if (children.isEmpty) {
      f(props).asInstanceOf[ReactComponentU_]
    } else if (children.size == 1) {
      f(props, children.head).asInstanceOf[ReactComponentU_]
    } else {
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
    }
  }

}
