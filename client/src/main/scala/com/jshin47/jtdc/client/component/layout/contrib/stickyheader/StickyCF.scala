package com.jshin47.jtdc.client.component.layout.contrib.stickyheader

import chandu0101.macros.tojs.JSMacro
import com.jshin47.jtdc.client.component.ComponentUtilities
import japgolly.scalajs.react.{React, ReactComponentU_, ReactNode}

import scala.scalajs.js


case class StickyCF(
                     isActive: js.UndefOr[Boolean]                       = true,
                     className: js.UndefOr[String]                       = "",
                     style: js.UndefOr[js.Any]                           = js.undefined,
                     stickyClassName: js.UndefOr[String]                 = "sticky",
                     stickyStyle: js.UndefOr[js.Any]                     = js.undefined,
                     topOffset: js.UndefOr[Int]                          = 0,
                     bottomOffset: js.UndefOr[Int]                       = 0,
                     onStickyStateChange: js.Function                    = js.Any.fromFunction0(() ⇒ ()),
                     key: js.UndefOr[String]                             = ComponentUtilities.generateKey,
                     ref: js.UndefOr[String]                             = js.undefined
                   ) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[StickyCF](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(ReactSticky.Sticky)
    if (children.isEmpty) {
      f(props).asInstanceOf[ReactComponentU_]
    } else if (children.size == 1) {
      f(props, children.head).asInstanceOf[ReactComponentU_]
    } else {
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
    }
  }

}
