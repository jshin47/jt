package com.jshin47.jtdc.client

import com.jshin47.jtdc.client.module.post.PostListC
import com.jshin47.jtdc.client.state.{ApplicationCircuit, PostFilter}
import japgolly.scalajs.react.{ReactComponentU, TopNode}
import japgolly.scalajs.react.extra.router.{BaseUrl, Redirect, Resolution, Router, RouterConfig, RouterConfigDsl}
import org.scalajs.dom


object ApplicationRouter {

  val baseUrl = BaseUrl(dom.window.location.href.takeWhile(_ != '#))

  val routerConfig: RouterConfig[PostFilter] = RouterConfigDsl[PostFilter].buildConfig { dsl ⇒
    import dsl._

    def filterRoute(s: PostFilter): Rule =
      staticRoute("#/" + s.link, s) ~>
        renderR(router ⇒
          ApplicationCircuit
            .connect(_.posts)(p ⇒ PostListC(p, s, router)))

    def filterRoutes: Rule =
      PostFilter.values.map(filterRoute).reduce(_ | _)

    filterRoutes.notFound(redirectToPage(PostFilter.All)(Redirect.Replace))
  }

  val router: ReactComponentU[Unit, Resolution[PostFilter], Any, TopNode] = Router(baseUrl, routerConfig.logToConsole)()

  def apply() = router
}
