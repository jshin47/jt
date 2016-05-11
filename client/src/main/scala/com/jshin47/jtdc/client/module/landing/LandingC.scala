package com.jshin47.jtdc.client.module.landing

import chandu0101.scalajs.react.components.materialui._
import com.jshin47.jtdc.client.state._
import com.jshin47.jtdc.dto._
import japgolly.scalajs.react.extra.router._
import diode.react.ModelProxy
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.ext.KeyCode
import chandu0101.scalajs.react.components.Implicits._
import com.jshin47.jtdc.client.Loc
import com.jshin47.jtdc.client.component.layout.contrib.cellblock.{CellblockColumnCF, CellblockGridCF, CellblockRowCF}
import com.jshin47.jtdc.client.component.masthead.MastheadC
import com.jshin47.jtdc.client.module.visualization.{D3TreeStateVisualizerC, DiodeStateVizC}


import scalacss.ScalaCssReact._

object LandingC {

  private val component = ReactComponentB[RouterCtl[Loc]]("LandingLocation")
    .render_P(ctl ⇒ {
      <.div()(
        ApplicationCircuit.connect(_.masthead)(proxy ⇒ MastheadC(MastheadC.Props(proxy))()),
        ApplicationCircuit.connect(m ⇒ m)(proxy ⇒ DiodeStateVizC(DiodeStateVizC.Props(proxy))),
        CellblockGridCF()(
          CellblockRowCF()(
            CellblockColumnCF(width = "2/3", key = "col1")(
              <.div(^.backgroundColor := "red", ^.width := "100%", ^.height := "100%")
            ),
            CellblockColumnCF(width = "1/3", key = "col2")(
              <.div(^.backgroundColor := "blue", ^.width := "100%", ^.height := "100%")
            )
          )
        )
      )
    })
    .build

  def apply(routerCtl: RouterCtl[Loc]) = component(routerCtl)

}
