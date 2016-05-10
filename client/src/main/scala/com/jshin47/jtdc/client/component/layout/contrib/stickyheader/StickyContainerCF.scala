package com.jshin47.jtdc.client.component.layout.contrib.stickyheader

import chandu0101.macros.tojs.JSMacro
import com.jshin47.jtdc.client.component.ComponentUtilities
import japgolly.scalajs.react.{React, ReactChildren, ReactComponentU_, ReactNode}

import scala.scalajs.js

/**
  * Created by justin on 5/10/16.
  */
case class StickyContainerCF(
                              container: js.UndefOr[js.Any]           = js.undefined,
                              offset: js.UndefOr[Int]                 = 0,
                              totalOffset: js.UndefOr[Int]            = 0,
                              rect: js.UndefOr[js.Any]                = js.undefined,
                              key: js.UndefOr[String]                 = ComponentUtilities.generateKey
                            ) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[StickyContainerCF](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(ReactSticky.StickyContainer)
    if (children.isEmpty) {
      f(props).asInstanceOf[ReactComponentU_]
    } else if (children.size == 1) {
      f(props, children.head).asInstanceOf[ReactComponentU_]
    } else {
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
    }
  }

}