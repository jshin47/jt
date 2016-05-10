package com.jshin47.jtdc.client.component.layout.contrib.cellblock

import java.util.UUID

import chandu0101.macros.tojs.JSMacro
import com.jshin47.jtdc.client.component.ComponentUtilities
import japgolly.scalajs.react.{React, ReactComponentU_, ReactNode}

import scala.scalajs.js

case class CellblockColumnCF(
                              breakCount: js.UndefOr[Int]                   = js.undefined,
                              className:  js.UndefOr[String]                = js.undefined,
                              isRoot:     js.UndefOr[Boolean]               = js.undefined,
                              offset:     js.UndefOr[String]                = js.undefined,
                              viewport:   js.UndefOr[js.Array[js.Any]]      = js.undefined,
                              width:      js.UndefOr[String]                = js.undefined,
                              key:        js.UndefOr[String]                = ComponentUtilities.generateKey,
                              ref:        js.UndefOr[String]                = js.undefined
                            ) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[CellblockColumnCF](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Cellblock.Column)
    if (children.isEmpty) {
      f(props).asInstanceOf[ReactComponentU_]
    } else if (children.size == 1) {
      f(props, children.head).asInstanceOf[ReactComponentU_]
    } else {
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
    }
  }

}