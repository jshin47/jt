package com.jshin47.jtdc.client.module.visualization

import com.jshin47.jtdc.client.state._
import diode.react._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scalacss.Defaults._
import scalacss.ScalaCssReact._
import chandu0101.scalajs.react.components.Implicits._
import com.jshin47.jtdc.client.{ApplicationRouter, Main}

import scala.collection.mutable
import scala.scalajs.js

// wraps the component for making tree
object DiodeStateVizC {

  object DiodeStateVizZ extends StyleSheet.Inline {

  }

  case class Props(
                    proxy: ModelProxy[ApplicationModel]
                  )

  type State = Unit

  val component = ReactComponentB[Props]("AppModelDiodeState")
    .stateless
    .noBackend
    .render_P( props ⇒ {

      D3TreeStateVisualizerC(
        new D3TreeStateVisualizerC.Props(
          id = "tree",
          size = 600,
          aspectRatio = 0.5,
          isSorted = false,
          widthBetweenNodesCoeff = 1.5,
          heightBetweenNodesCoeff = 2.0,
          rootKeyName = "dd",
          //state = props.proxy().asInstanceOf[js.Object]
          state = D3TreeStateVisualizerC.fictState
        )
      )
    })
    .build

  def apply(props: Props) = component(props)

}
