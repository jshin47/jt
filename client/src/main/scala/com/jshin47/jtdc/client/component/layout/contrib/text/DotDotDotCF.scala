package com.jshin47.jtdc.client.component.layout.contrib.text

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react.{React, ReactComponentU_, ReactNode}

import scala.scalajs.js

/**
  * Created by justin on 5/11/16.
  */
case class DotDotDotCF(
                        clamp:    js.Any         = "auto",
                        ellipsis: String         = "…"
                      ) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[DotDotDotCF](this)
    val     f = React.asInstanceOf[js.Dynamic].createFactory(DotDotDotCF)
    if (children.isEmpty) {
      f(props).asInstanceOf[ReactComponentU_]
    } else if (children.size == 1) {
      f(props, children.head).asInstanceOf[ReactComponentU_]
    } else {
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
    }
  }

}