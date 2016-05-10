package com.jshin47.jtdc.dto

import java.util.UUID

case class PostId(id: UUID) extends Dto

object PostId {
  def generate = new PostId(UUID.randomUUID())
}



case class Post(id: PostId, author: String, title: String, content: String) extends Dto

object Post {
  def create(by: String, titled: String, content: String) =
    Post(PostId.generate, by, titled, content)
}




case class Posts(postList: Seq[Post]) extends Dto

object Posts {

  implicit class PostsExt(posts: Seq[Post]) {
    def toPosts: Posts = Posts(posts)
  }

}

