package com.jshin47.jtdc.client.module.visualization

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
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}
import scalacss.ScalaCssReact._
import scalacss.Defaults._
import scalatags.generic.Style

@js.native
@JSName("window.TreeSvg")
object TreeSvg extends js.Object {

  @JSName("tree")
  def tree(
            domNode: dom.raw.Node,
            dictionary: Any
          ): js.Dynamic =
    js.native
}

object D3TreeStateVisualizerC {

  @ScalaJSDefined
  class Props(
                    val state: Any                                      = null,
                    val tree: Any                                       = null,
                    val id: String                                      = "stategraph",
                    val style: Style                                    = Style("sgs", "sgs"),
                    val size: Int                                       = 500,
                    val aspectRatio: Double                             = 1.0,
                    val heightBetweenNodesCoeff: Double                 = 1.0,
                    val widthBetweenNodesCoeff: Double                  = 1.0,
                    val isSorted: Boolean                               = false,
                    val transitionDuration: Int                         = 750,
                    val rootKeyName: String                             = "state",
                    val pushMethod: String                              = "push"
                  )
  extends js.Object




  val fictState: js.Dictionary[js.Any] = js.Dictionary(
    "state" → js.Dictionary(
      "todos" → js.Array(
        js.Dictionary("title" → "d3"),
        js.Dictionary("title" → "Anbooein"),
        js.Dictionary("title" → "Shazam@31"),
        js.Dictionary("title" → "whbatits to you )"),
        js.Dictionary("title" → "bang bvnang boommmmm!!14311")
      )
    )
  )

  val fictObj = fictState.asInstanceOf[js.Object]

  class Backend($: BackendScope[Props, _]) {

    var renderChart: js.Dynamic = _

    def whenMount_setRenderChart(p: Props): Callback = Callback {
      this.renderChart = TreeSvg.tree(ReactDOM.findDOMNode($), p)
      js.Dynamic.global.window.renderChart = renderChart
      this.renderChart()
    }

    def onComponentWillReceiveProps(next: Props) = CallbackTo {
      if (next.tree == null)
         Callback { this.renderChart(next.state.asInstanceOf[js.Any]) }
      else
         Callback { this.renderChart(next.tree.asInstanceOf[js.Any]) }
    }.flatten

    def render(p: Props) =
      <.div(^.className := "container")

  }

  val component = ReactComponentB[Props]("TreeChart")
    .stateless
    .backend($ ⇒ new Backend($))
    .renderBackend
    .componentDidMount(scope ⇒ scope.backend.whenMount_setRenderChart(scope.props))
    .componentWillReceiveProps(X ⇒ X.$.backend.onComponentWillReceiveProps(X.nextProps))
    .build

  def apply(props: Props) = component(props)

}
