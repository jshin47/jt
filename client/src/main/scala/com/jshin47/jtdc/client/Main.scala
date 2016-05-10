package com.jshin47.jtdc.client

import japgolly.scalajs.react.{ReactComponentB, ReactDOM}

import scala.scalajs.js.annotation.JSExport
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalacss.mutable.GlobalRegistry
import org.scalajs.dom
import japgolly.scalajs.react.extra.router._
import japgolly.scalajs.react.vdom.prefix_<^._
import chandu0101.scalajs.react.components.Implicits._
import boopickle.Default._

import scala.scalajs.js.JSApp
import com.jshin47.jtdc.client.state.{ApplicationCircuit, ApplicationModel, InitializePosts}
import com.jshin47.jtdc.client.style.{ApplicationStyles, StyleRegistry}


object Main extends JSApp {

  @JSExport
  override def main(): Unit = {
    // Styling bullshit
    StyleRegistry.load()
    GlobalRegistry.addToDocumentOnRegistration()

    // Init
    ApplicationCircuit.dispatch(InitializePosts)

    // Render into new child div of body. Could've rendered right into body but didn't.
    ReactDOM.render(ApplicationRouter(), dom.document.body.appendChild(dom.document.createElement("div")))
  }

}
