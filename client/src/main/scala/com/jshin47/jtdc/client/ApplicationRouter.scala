package com.jshin47.jtdc.client

import java.util.regex.Pattern

import com.jshin47.jtdc.client.component.layout.parallax.ParallaxContainerC
import com.jshin47.jtdc.client.module.demonstration.DemonstrationLocC
import japgolly.scalajs.react.extra.router._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import com.jshin47.jtdc.client.module.landing.{FourOhFourC, LandingLocC}
import com.jshin47.jtdc.client.style.ApplicationStyles
import org.scalajs.dom

import scala.util.matching.Regex
import scalacss.ScalaCssReact._


object ApplicationRouter {

  // Rationale being, this is the url prior to the anchor, which the browser will not send to the server.

  val baseUrl = BaseUrl(dom.window.location.href.split('#')(0) + "#")

  val routerConfig: RouterConfig[Loc] = RouterConfigDsl[Loc].buildConfig { dsl ⇒
    import dsl._

    def formatRouteName(cls: Any): String = cls.getClass.getSimpleName
      .replace("$","")
      .replace("Loc","")
      .replace("_", "")

    def formatRoutePath(cls: Any): String = "#" + formatRouteName(cls).toLowerCase

    (removeTrailingSlashes
      //| staticRedirect(root) ~> redirectToPage(LandingLoc)(Redirect.Replace)
      | staticRoute(formatRouteName(LandingLoc), LandingLoc) ~> renderR(ctl ⇒ LandingLocC(ctl))
      | staticRoute(formatRouteName(DemonstrationLoc), DemonstrationLoc) ~> renderR(ctl ⇒ DemonstrationLocC(ctl))
      | staticRoute(formatRouteName(Error_404_Loc), Error_404_Loc) ~> renderR(ctl ⇒ ParallaxContainerC())
      | staticRedirect("#404") ~> redirectToPage(Error_404_Loc)(Redirect.Replace)
    ).notFound(redirectToPage(Error_404_Loc)(Redirect.Replace))
     .logToConsole
     .renderWith { (ctl, res) ⇒
       <.div(res.render())
     }
  }

  val router: ReactComponentU[Unit, Resolution[Loc], Any, TopNode] =
    Router(baseUrl, routerConfig)()

  def apply() = router
}
