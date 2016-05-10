package com.jshin47.jtdc.client.component.layout.contrib.cellblock

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react.{React, ReactComponentU_, ReactNode}

import scala.scalajs.js


case class CellblockRowCF(
                           className: String = ""
                         ) {
  def apply(children: ReactNode*) = {
    val props = JSMacro[CellblockRowCF](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Cellblock.Row)
    if (children.isEmpty) {
      f(props).asInstanceOf[ReactComponentU_]
    } else if (children.size == 1) {
      f(props, children.head).asInstanceOf[ReactComponentU_]
    } else {
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
    }
  }

}
