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
import com.jshin47.jtdc.client.component.masthead.MastheadC
import com.jshin47.jtdc.client.module.visualization.{D3TreeStateVisualizerC, DiodeStateVizC}

import scalacss.ScalaCssReact._

object LandingLocC {

  private val component = ReactComponentB[RouterCtl[Loc]]("LandingLocation")
    .render_P(ctl ⇒ {
      <.div()(
        ApplicationCircuit.connect(_.masthead)(proxy ⇒ MastheadC(MastheadC.Props(proxy))()),
        ApplicationCircuit.connect(m ⇒ m)(proxy ⇒ DiodeStateVizC(DiodeStateVizC.Props(proxy)))
      )
    })
    .build

  def apply(routerCtl: RouterCtl[Loc]) = component(routerCtl)

}
