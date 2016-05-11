package com.jshin47.jtdc.client.module.demonstration

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
import com.jshin47.jtdc.client.component.layout.contrib.cellblock.{CellblockColumnCF, CellblockGridCF, CellblockRowCF}
import com.jshin47.jtdc.client.component.layout.contrib.stickyheader.{StickyCF, StickyContainerCF}

object DemonstrationC {

  private val component = ReactComponentB[RouterCtl[Loc]]("DemonstrationLocC")
    .render_P(ctl ⇒ {
      StickyContainerCF()(
        CellblockGridCF()(
          CellblockRowCF()(
            CellblockColumnCF()(
              <.div(
                ^.height := "800px",
                ^.backgroundColor := "#d2691e",
                ^.color := "white"
              )(
                <.h2("watch it stick!"),
                <.h2("stick!"),
                <.h2("stick!")
              )
            )
          ),
          StickyCF()(
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
            )
          ),
          CellblockRowCF()(
            CellblockColumnCF(width = "1/4")(
              <.div(^.backgroundColor := "magenta")(
                "blah blah"
              )
            ),
            CellblockColumnCF(width = "3/4")(
              <.div(^.height := "1000px", ^.backgroundColor := "cyan")(
                "black sheep"
              )
            )
          )
        )
      )
    })
    .build

  def apply(routerCtl: RouterCtl[Loc]) = component(routerCtl)

}
