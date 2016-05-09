package com.jshin47.jtdc.client.state

import com.jshin47.jtdc.dto.Posts
import diode.Circuit
import diode.react.ReactConnector

/**
  * Created by justin on 5/7/16.
  */
object ApplicationCircuit
  extends Circuit[ApplicationModel]
  with ReactConnector[ApplicationModel] {
  override protected def initialModel: ApplicationModel = ApplicationModel(Posts(Seq()))

  override protected def actionHandler = composeHandlers(
    new PostHandler(zoomRW(_.posts)((m,v) ⇒ m.copy(posts = v)).zoomRW(_.postList)((m, v) ⇒ m.copy(postList = v)))
  )
}