package com.jshin47.jtdc.client

import japgolly.scalajs.react.extra.router._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import com.jshin47.jtdc.client.module.landing.LandingLocC
import com.jshin47.jtdc.client.style.ApplicationStyles
import org.scalajs.dom
import scalacss.ScalaCssReact._


object ApplicationRouter {

  // Rationale being, this is the url prior to the anchor, which the browser will not send to the server.
  val baseUrl = BaseUrl(dom.window.location.href.takeWhile(_ != '#))

  val routerConfig: RouterConfig[Loc] = RouterConfigDsl[Loc].buildConfig { dsl ⇒
    import dsl._

    (staticRoute(root, LandingLoc) ~> renderR(ctl ⇒ LandingLocC(ctl)))
      .notFound(redirectToPage(LandingLoc)(Redirect.Replace))

  }

  def layout(c: RouterCtl[Loc], r: Resolution[Loc]): Unit = {
    <.div()(
      r.render()
    )
  }

  val router: ReactComponentU[Unit, Resolution[Loc], Any, TopNode] =
    Router(baseUrl, routerConfig.logToConsole)()

  def apply() = router
}
