package com.jshin47.jtdc.client.state

import com.jshin47.jtdc.client.state.handler.{MastheadHandler, PostHandler}
import com.jshin47.jtdc.client.state.processor.DiodeLogger
import com.jshin47.jtdc.dto.{Masthead, NavigationItems, Posts}
import diode.{ActionResult, Circuit}
import diode.react.ReactConnector

/**
  * Created by justin on 5/7/16.
  */
object ApplicationCircuit
  extends Circuit[ApplicationModel]
  with ReactConnector[ApplicationModel] {

  addProcessor(new DiodeLogger[ApplicationModel]())

  override protected def initialModel: ApplicationModel = ApplicationModel(
    Posts(Seq()),
    Masthead(NavigationItems(Seq()), "JustinTampa", "JustinTampa.com", active = false)
  )

  override protected def actionHandler = composeHandlers(
    new PostHandler(
      zoomRW(_.posts)((m,v) ⇒ m.copy(posts = v)).zoomRW(_.postList)((m, v) ⇒ m.copy(postList = v))),
    new MastheadHandler(
      zoomRW(_.masthead)((m,v) ⇒ m.copy(masthead = v)))
  )

}