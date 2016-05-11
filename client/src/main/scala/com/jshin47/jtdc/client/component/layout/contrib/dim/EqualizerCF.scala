package com.jshin47.jtdc.client.component.layout.contrib.dim

import chandu0101.macros.tojs.JSMacro
import com.jshin47.jtdc.client.component.layout.contrib.ReactEqualizer
import japgolly.scalajs.react.{React, ReactComponentU_, ReactNode}
import org.scalajs.dom

import scala.scalajs.js

case class EqualizerCF(
                        property:                                            String    = "height",
                        byRow:                                              Boolean    = true,
                        enabled:      js.UndefOr[Function2[Any, dom.Node, Boolean]]    = js.undefined,
                        nodes:         js.UndefOr[Function2[Any, dom.Node, js.Any]]    = js.undefined
                      ) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[EqualizerCF](this)
    def f = React.asInstanceOf[js.Dynamic].createFactory(ReactEqualizer.default)
    if (children.isEmpty) {
      f(props).asInstanceOf[ReactComponentU_]
    } else if (children.size == 1) {
      f(props, children.head).asInstanceOf[ReactComponentU_]
    } else {
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
    }
  }

}
