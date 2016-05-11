package com.jshin47.jtdc.dto

case class Post(
                 contentItem: ContentItem,
                 author: String,
                 title: String,
                 content: String
               )
  extends Dto

object Post {
  def create(by: String, titled: String, content: String) =
    Post(ContentItem.generate, by, titled, content)
}




case class Posts(postList: Seq[Post]) extends Dto

object Posts {

  implicit class PostsExt(posts: Seq[Post]) {
    def toPosts: Posts = Posts(posts)
  }

}

case class PostFilter(
                       beforeDate: String = "",
                       afterDate:  String = "",
                       content:    String = "",
                       title:      String = "",
                       author:     String = "",
                       limit: Option[Int] = None,
                       page:       Int    = 0
                     ) extends FilterDto[Post]