package com.jshin47.jtdc.client.module.landing

import chandu0101.scalajs.react.components.materialui.{MuiPaper, MuiSvgIcon, MuiTextField, ZDepth}
import com.jshin47.jtdc.client.state.{ApplicationCircuit}
import com.jshin47.jtdc.dto.{Post, Posts}
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
import com.jshin47.jtdc.client.component.gfx.icon.MuiSvgIcons
import com.jshin47.jtdc.client.component.layout.contrib.cellblock.{CellblockColumnCF, CellblockGridCF, CellblockRowCF}
import diode.ModelR

object PostListingC {

  sealed trait PostListingLayout
  case object  LayoutHorizontal  extends PostListingLayout
  case object  LayoutGrid        extends PostListingLayout

  case class Props(posts: Posts, layout: PostListingLayout)

  case class State()

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

    def willUnmount(props: Props): Callback = Callback {

    }

    def render(p: Props, s: State) = {
      CellblockGridCF()(
        CellblockRowCF()(
          CellblockColumnCF(width = "1/5")(
            <.div(
              // area to control posts filtering
            )
          ),
          CellblockColumnCF(width = "4/5")(
            <.div(
              p.posts.postList.map {
                case p: Post ⇒
                  ApplicationCircuit.connect(_.posts.postList.filterNot(x ⇒ x == p).head)(x ⇒ PostItemC(PostItemC.Props(x)))
              }
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
    .build
    //.componentWillMount($ ⇒ $.backend.willMount($.props))
    //.componentDidMount($ ⇒ $.backend.mounted($.props))
    //.componentWillReceiveProps(p ⇒ p.$.backend.willReceiveProps(p.nextProps))
    //.shouldComponentUpdate(s ⇒ s.$.backend.shouldUpdate(s.nextProps, s.nextState))
    //.componentWillUpdate(up ⇒ up.$.backend.willUpdate(up.nextProps, up.nextState))
    //.componentDidUpdate(up ⇒ up.$.backend.didUpdate(up.prevProps, up.prevState))
    //.componentWillUnmount(c ⇒ c.backend.willUnmount(c.props))

  def apply(props: Props) = component(props)

}
