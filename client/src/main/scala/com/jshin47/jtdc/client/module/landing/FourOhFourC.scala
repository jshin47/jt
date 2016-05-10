package com.jshin47.jtdc.client.module.landing

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
import com.jshin47.jtdc.client.Loc
import com.jshin47.jtdc.client.component.layout.contrib.cellblock.{CellblockColumnCF, CellblockGridCF, CellblockRowCF}

object FourOhFourC {


  type Props = RouterCtl[Loc]
  type State = Unit

  class Backend($: BackendScope[Props, State]) {

    def mounted(p: Props): Callback = Callback {

    }

    def render(p: Props, s: State) = {
      CellblockGridCF()(
        CellblockRowCF()(
          CellblockColumnCF(width = "1/2", offset = "1/4")(
            <.div(
              <.h1(^.fontFamily := "Open Sans, Verdana")(
                "Oh dear!"
              ),
              <.h2("It looks like you've ended up in the middle of nowhere!")
            )
          )
        )
      )
    }

  }

  val component = ReactComponentB[Props]("FourOhFourC")
    .stateless
    .backend($ ⇒ new Backend($))
    .renderBackend
    //.componentDidMount($ ⇒ $.backend.mounted($.props))
    .build

  def apply(props: Props) = component(props)

}
