package com.jshin47.jtdc.client.component.layout.parallax

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
import com.jshin47.jtdc.client.component.layout.parallax.SkrollrFacade.SkrollrFInstance

import scala.scalajs.js.{Any, WrappedDictionary}

object ParallaxContainerC {


  case class Props(proxy: ModelProxy[Post] = null)

  type State = Unit

  class Backend($: BackendScope[Props, State]) {

    def mounted(p: Props): Callback = Callback {
      val sks = SkrollrFInstance(WrappedDictionary.empty)
      sks.smooth(true, 100).forceHeight(true).initSkrollr()

    }

    import SkrollrFacade.Attrs._

    def render(p: Props, s: State)   = {
      <.div(
        dataRelTopOfTop := "transform:translate(0,0%);",
        dataRel500pxScrolledDown := "transform:translate(0,-100%);",
        ^.backgroundColor := "red"
      )(

        "stuff"
      )
    }

  }

  val component = ReactComponentB[Props]("SkrollrDivC")
    .stateless
    .backend($ ⇒ new Backend($))
    .renderBackend
    .componentDidMount($ ⇒ $.backend.mounted($.props))
    .build

  def apply(props: Props = Props()) = component(props)

}
