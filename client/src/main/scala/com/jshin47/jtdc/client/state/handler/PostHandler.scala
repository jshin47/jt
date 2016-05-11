package com.jshin47.jtdc.client.state.handler

import com.jshin47.jtdc.client.state.RefreshPost
import com.jshin47.jtdc.dto.{ContentItem, Post, Posts}
import diode.{ActionHandler, ActionResult, ModelRW}

/**
  * Created by justin on 5/7/16.
  */
class PostHandler[M](modelRW: ModelRW[M, Posts]) extends ActionHandler(modelRW) {

  def updateOne(id: ContentItem)(f: Post => Post): Seq[Post] =
    value.postList.map {
      case found@Post(id, _, _, _) ⇒ f(found)
      case otherwise ⇒ otherwise
    }

  override protected def handle: PartialFunction[AnyRef, ActionResult[M]] = {
    case RefreshPost(post, pot) ⇒
      noChange
  }
}
