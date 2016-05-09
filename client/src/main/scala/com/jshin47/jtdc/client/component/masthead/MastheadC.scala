package com.jshin47.jtdc.client.component.masthead

import chandu0101.scalajs.react.components.materialui._
import com.jshin47.jtdc.client.state._
import com.jshin47.jtdc.dto._
import japgolly.scalajs.react.extra.router._
import diode.react.ModelProxy
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.ext.KeyCode
import chandu0101.scalajs.react.components.Implicits._
import scalacss.ScalaCssReact._

import scalacss.Defaults._

object MastheadC {

  val zHeight = 120

  object MastheadZ extends StyleSheet.Inline {

    import dsl._

    val masthead = style(
      position.fixed,
      lineHeight.normal,
      height(zHeight px),
      width(100 %%)
    )

    val `masthead-logo` = style(
      textAlign.center
    )

    val mastheadBackground = styleF.bool(active ⇒
      styleS(backgroundColor(if (active) darkred else red))
    )

  }

  MastheadZ.addToDocument()

  case class Props(
                    proxy: ModelProxy[Masthead]
                  )

  case class State(

                  )

  class Backend($: BackendScope[Props, State]) {

    def render(p: Props, s: State) ={
      val proxy = p.proxy()
      val dispatch = p.proxy.dispatch

      <.div(
        MastheadZ.masthead,
        if (proxy.active) { ^.backgroundColor := "red" }
        else { ^.backgroundColor := "yellow" },
        ^.onMouseOver --> dispatch(MastheadIsActive(true)),
        ^.onMouseOut  --> dispatch(MastheadIsActive(false))
      )(
      )
    }
  }

  private val component = ReactComponentB[Props]("Masthead")
    .initialState_P(p ⇒ State())
    .backend($ ⇒ new Backend($))
    .renderBackend
    .build

  def apply(props: Props)(children: ReactNode*) = component(props, children)

}
