package com.jshin47.jtdc.client.state

import com.jshin47.jtdc.dto.{Post, PostId}
import diode.{ActionHandler, ActionResult, ModelRW}

/**
  * Created by justin on 5/7/16.
  */
class PostHandler[M](modelRW: ModelRW[M, Seq[Post]]) extends ActionHandler(modelRW) {

  def updateOne(id: PostId)(f: Post => Post): Seq[Post] =
    value.map {
      case found@Post(id, _, _, _) ⇒ f(found)
      case otherwise ⇒ otherwise
    }

  override protected def handle: PartialFunction[AnyRef, ActionResult[M]] = {
    case InitializePosts ⇒
      println("Initializing posts!")
      updated(List(Post.create("Justin Shin", "My First Post", "This is an example of a post")))
    case AddPost(title, post, author) ⇒
      updated(value :+ Post(PostId.generate, author, title, post))
    case UpdatePost(id, maybeTitle, maybeContent) ⇒
      updated(updateOne(id)(old ⇒ old.copy(title = maybeTitle.getOrElse(old.title), content = maybeContent.getOrElse(old.content))))
    case DeletePost(id) ⇒
      updated(value.filterNot(_.id == id))
    case _ => updated(value)
  }
}
