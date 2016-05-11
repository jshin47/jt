package com.jshin47.jtdc.client.component.layout.twocol

import chandu0101.scalajs.react.components.materialui.MuiTextField
import com.jshin47.jtdc.dto.{Post, ContentItem, Posts}
import diode.react.ModelProxy
import japgolly.scalajs.react.{BackendScope, Callback}
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router._
import diode.react.ModelProxy
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.ext.KeyCode
import chandu0101.scalajs.react.components.Implicits._

object TwoColumnLayoutC {

  case class Props()
  case class State()

  class Backend($: BackendScope[Props, State]) {

    def mounted(p: Props): Callback = Callback {

    }

    def render(p: Props, s: State) = {
      <.div()
    }

  }

  val component = ReactComponentB[Props]("TwoColumnLayoutC")
    .initialState_P(p ⇒ State())
    .backend($ ⇒ new Backend($))
    .renderBackend
    .componentDidMount($ ⇒ $.backend.mounted($.props))
    .build

  def apply(props: Props) = component(props)

}
