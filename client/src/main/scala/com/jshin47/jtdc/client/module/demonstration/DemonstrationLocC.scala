package com.jshin47.jtdc.client.module.demonstration

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
import com.jshin47.jtdc.client.component.layout.contrib.stickyheader.{StickyCF, StickyContainerCF}

object DemonstrationLocC {

  private val component = ReactComponentB[RouterCtl[Loc]]("DemonstrationLocC")
    .render_P(ctl ⇒ {
        CellblockGridCF()(
            CellblockRowCF()(
              CellblockColumnCF()(
                <.div(
                  ^.backgroundColor := "#ffcc00",
                  ^.minHeight := "120px",
                  ^.color := "white"
                )(
                  "Hello world!"
                )
              )
          ),
          CellblockRowCF()(
            CellblockColumnCF(width = "1/4")(
              <.div(
                "blah blah"
              )
            ),
            CellblockColumnCF(width = "3/4")(
              <.div(
                "black sheep"
              )
            )
          )
      )
    })
    .build

  def apply(routerCtl: RouterCtl[Loc]) = component(routerCtl)

}
