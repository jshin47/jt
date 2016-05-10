package com.jshin47.jtdc.client.module.post

import chandu0101.scalajs.react.components.materialui.MuiTextField
import com.jshin47.jtdc.client.state.{AddPost, PostFilter}
import com.jshin47.jtdc.dto.{Post, PostId, Posts}
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

object PostListC {


  case class Props(proxy: ModelProxy[Posts])

  type State = Unit

  class Backend($: BackendScope[Props, State]) {

    def mounted(p: Props): Callback = Callback {

    }

    def render(p: Props, s: State) = {
      <.div()
    }

  }

  val component = ReactComponentB[Props]("PostListC")
    .stateless
    .backend($ ⇒ new Backend($))
    .renderBackend
    .componentDidMount($ ⇒ $.backend.mounted($.props))
    .build

  def apply(props: Props) = component(props)

}
