package com.jshin47.jtdc.client.component.layout.contrib.cellblock

import chandu0101.macros.tojs.JSMacro
import com.jshin47.jtdc.client.component.ComponentUtilities
import japgolly.scalajs.react.{React, ReactComponentU_, ReactNode}

import scala.scalajs.js

/**
  * Created by justin on 5/10/16.
  */
case class CellblockGridCF(
                            breakpoints:          js.UndefOr[js.Any]                      = js.undefined,
                            className:            js.UndefOr[String]                      = js.undefined,
                            columnWidth:          js.UndefOr[Double]                      = js.undefined,
                            flexible:             js.UndefOr[js.Any]                      = js.undefined,
                            gutterWidth:          js.UndefOr[Double]                      = js.undefined,
                            initialBreakpoint:    js.UndefOr[js.Any]                      = js.undefined,
                            onChange:             js.UndefOr[js.Function1[js.Any, Unit]]  = js.undefined,
                            key:                  js.UndefOr[String]                      = ComponentUtilities.generateKey,
                            ref:                  js.UndefOr[String]                      = js.undefined
                          ) {
  def apply(children: ReactNode*) = {
    val props = JSMacro[CellblockGridCF](this)
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
