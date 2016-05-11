package com.jshin47.jtdc.server.route
import akka.http.scaladsl._
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.ws._
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Sink, Source, Flow}
import akka.util.ByteString
import com.google.common.io.ByteSource
import akka.http.scaladsl.server.{Directives, Route}
import akka.stream.ActorMaterializer
import com.jshin47.jtdc.api.{ApiDef, ApiImpl}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.collection.JavaConversions._
import scala.concurrent.Future
import scala.util.Properties
import upickle.Js
import upickle.default._

object Router extends autowire.Server[Js.Value, Reader, Writer]{
  def read[Result: Reader](p: Js.Value) = upickle.default.readJs[Result](p)
  def write[Result: Writer](r: Result) = upickle.default.writeJs(r)
}

trait ApiRoutes {

  this: Directives with UPickleSupport ⇒

  implicit def mat: ActorMaterializer

  val allApiRoutes: Route = {

    pathPrefix("api") {
      //completeWithAutowire(server.route[ApiDef](new ApiImpl()))

      path(Segments) { s ⇒
        entity(as[String]) { e ⇒
          complete {
            Router.route[ApiDef](new ApiImpl())(
              autowire.Core.Request(
                s,
                upickle.json.read(e).asInstanceOf[Js.Obj].value.toMap
              )
            )
          }
        }
      }
    }

  }
}