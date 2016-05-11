package com.jshin47.jtdc.server.route

import akka.http.scaladsl.marshalling.{ Marshaller, ToEntityMarshaller }
import akka.http.scaladsl.model.MediaTypes.`application/json`
import akka.http.scaladsl.unmarshalling.{ FromEntityUnmarshaller, Unmarshaller }
import upickle.default.{ Reader, Writer, readJs, writeJs }
import upickle.{ Js, json }

trait UPickleSupport {


  /**
    * HTTP entity => `A`
    *
    * @param reader reader for `A`
    * @tparam A type to decode
    * @return unmarshaller for `A`
    */
  implicit def upickleUnmarshaller[A](implicit reader: Reader[A]): FromEntityUnmarshaller[A] =
    Unmarshaller.byteStringUnmarshaller
      .forContentTypes(`application/json`)
      .mapWithCharset((data, charset) => readJs[A](json.read(data.decodeString(charset.nioCharset.name))))

  /**
    * `A` => HTTP entity
    *
    * @param writer writer for `A`
    * @param printer pretty printer function
    * @tparam A type to encode
    * @return marshaller for any `A` value
    */
  implicit def upickleMarshaller[A](implicit writer: Writer[A], printer: Js.Value => String = json.write(_, 0)): ToEntityMarshaller[A] =
    Marshaller.StringMarshaller.wrap(`application/json`)(printer).compose(writeJs[A])
}

object UPickleSupport extends UPickleSupport