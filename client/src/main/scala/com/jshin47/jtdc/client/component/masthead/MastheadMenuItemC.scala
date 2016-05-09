package com.jshin47.jtdc.client.component.masthead

import japgolly.scalajs.react.BackendScope

/**
  * Created by justin on 5/9/16.
  */
object MastheadMenuItemC {

  case class Props(
                    title:  String,
                    text:   String,
                    active: Boolean
                  )

  case class State(
                    hovered: Boolean
                  )

  class Backend($: BackendScope[Props, State]) {

    def render(p: Props, s: State) = {

    }

  }

}
