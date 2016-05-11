package com.jshin47.jtdc.client.module.landing

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
import com.jshin47.jtdc.client.Loc

object RootLayoutC {


  case class Props(proxy: RouterCtl[Loc])
  case class State()

  class Backend($: BackendScope[Props, State]) {

    def willMount(p: Props): Callback = Callback {

    }

    def mounted(p: Props): Callback = Callback {

    }

    def willReceiveProps(nextProps: Props): Callback = Callback {

    }

    def shouldUpdate(next: Props, nextState: State): Boolean = {
      true
    }


    def willUpdate(p: Props, s: State): Callback = Callback {

    }

    def didUpdate(previousProps: Props, previousState: State): Callback = Callback {

    }

    def willUNmount(props: Props): Callback = Callback {

    }

    def render(p: Props, s: State) = {
      <.div(

      )
    }

  }

  val component = ReactComponentB[Props]("RootLayoutC")
    .initialState(State())
    .backend($ ⇒ new Backend($))
    .renderBackend
    .componentWillMount($ ⇒ $.backend.willMount($.props))
    .componentDidMount($ ⇒ $.backend.mounted($.props))
    .componentWillReceiveProps(p ⇒ p.$.backend.willReceiveProps(p.nextProps))
    .shouldComponentUpdate(s ⇒ s.$.backend.shouldUpdate(s.nextProps, s.nextState))
    .componentWillUpdate(up ⇒ up.$.backend.willUpdate(up.nextProps, up.nextState))
    .componentDidUpdate(up ⇒ up.$.backend.didUpdate(up.prevProps, up.prevState))
    .componentWillUnmount(c ⇒ c.backend.willUNmount(c.props))
    .build

  def apply(props: Props) = component(props)

}
