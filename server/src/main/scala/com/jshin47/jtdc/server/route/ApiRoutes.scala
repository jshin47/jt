package com.jshin47.jtdc.server.route

import akka.http.scaladsl.server.{Directives, Route}
import akka.stream.ActorMaterializer
import com.jshin47.jtdc.api.{ApiDef, ApiImpl}
import prickle.Pickler._
import com.jshin47.common.serialization.PrickleExtras
import upickle.Js
import upickle.Js.Value
import upickle.default.{Reader, Writer}

import scala.concurrent.{ExecutionContext, Future}


trait ApiRoutes {

  this: AutowireApiRouting with Directives ⇒

  implicit def mat: ActorMaterializer

  val allApiRoutes: Route = {

    pathPrefix("api") {
      completeWithAutowire(server.route[ApiDef](new ApiImpl()))
    }

  }
}