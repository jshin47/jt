package com.jshin47.jtdc.server.route

import scalatags.Text.TypedTag
import akka.http.scaladsl.model._
import akka.http.scaladsl.marshalling._

trait ScalaTagsSupport {

  implicit def scalaTagsMarshaller: ToEntityMarshaller[TypedTag[String]] =
    Marshaller.StringMarshaller.wrap(MediaTypes.`text/html`)(_.toString)
}
