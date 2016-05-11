package com.jshin47.jtdc.client.module.landing

import chandu0101.scalajs.react.components.materialui._
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
import com.jshin47.jtdc.client.component.ComponentUtilities
import com.jshin47.jtdc.client.component.layout.contrib.cellblock.{CellblockColumnCF, CellblockGridCF, CellblockRowCF}
import com.jshin47.jtdc.dto.Post

import scala.scalajs.js

object PostItemC {

  import scalacss.Defaults._
  import scalacss.ScalaCssReact._

  object PostItemZ extends StyleSheet.Inline {

    import dsl._

    val zSeparationBetween = style(
      margin.horizontal(1 em),
      margin.vertical(1.5 em)
    )


  }

  PostItemZ.addToDocument()


  case class Props(proxy: ModelProxy[Post])
  case class State(displayAsListItem: Boolean = true)

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
      val model = p proxy()
      <.div(PostItemZ.zSeparationBetween)(
        MuiPaper(zDepth = ZDepth._1, key = ComponentUtilities.generateKey, circle = false, rounded = true, transitionEnabled = false)(
          CellblockGridCF()(
            CellblockRowCF()(
              CellblockColumnCF(width = "1/4")(
                <.div(
                  MuiAvatar(
                    key = ComponentUtilities.generateKey,
                    size = 112,
                    color = Mui.Styles.Colors.red400,
                    style = js.Dynamic.literal(
                      margin  =  "auto",
                      display = "block",
                      padding =  "10px"
                    )
                  )(Mui.SvgIcons.ActionFace()())
                )
              ),
              CellblockColumnCF(width = "3/4")(
                CellblockRowCF()(
                  <.div()(
                    <.h3(model.title)
                  )
                ),
                CellblockRowCF()(
                  <.div(^.maxHeight := "80%")(
                    <.div()(
                      <.p(model.content)
                    )
                  )
                )
              )
            )
          )
        )
      )
    }

  }

  val component = ReactComponentB[Props]("RootLayoutC")
    .initialState(State())
    .backend($ ⇒ new Backend($))
    .renderBackend
    //.componentWillMount($ ⇒ $.backend.willMount($.props))
    //.componentDidMount($ ⇒ $.backend.mounted($.props))
    //.componentWillReceiveProps(p ⇒ p.$.backend.willReceiveProps(p.nextProps))
    //.shouldComponentUpdate(s ⇒ s.$.backend.shouldUpdate(s.nextProps, s.nextState))
    //.componentWillUpdate(up ⇒ up.$.backend.willUpdate(up.nextProps, up.nextState))
    //.componentDidUpdate(up ⇒ up.$.backend.didUpdate(up.prevProps, up.prevState))
    //.componentWillUnmount(c ⇒ c.backend.willUNmount(c.props))
    .build

  def apply(props: Props) = component(props)

}
