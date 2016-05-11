package com.jshin47.jtdc.api
import com.jshin47.jtdc.dto.{Post, PostFilter}
import prickle._
import prickle.CompositePickler._
import scala.util.Random

class ApiImpl extends ApiDef {

  val authors: Seq[String] = Seq(
    "Justin Shin",
    "Austin Shin",
    "David Park",
    "Linkin Park",
    "Moose Man",
    "Tommy Lee Bones",
    "Bonerific V2"
  )

  val postFactory: () ⇒ Post =
    () ⇒ Post.create(
      authors(Random.nextInt(authors.length)),
      Random.nextString(Random.nextInt(1000)),
      Random.nextString(Random.nextInt(10000))
    )

  final lazy val posts =
    Iterator.range(0, 1000).map(_ ⇒ postFactory())

  def findPosts(
                 beforeDate: String = "",
                 afterDate:  String = "",
                 content:    String = "",
                 title:      String = "",
                 author:     String = "",
                 limit: Option[Int] = None,
                 page:       Int    = 0
               ): Seq[Post] = {
    posts
      .filter(p ⇒ content.trim.isEmpty || content.toLowerCase.contains(p.content.toLowerCase))
      .filter(p ⇒ title.trim.isEmpty   || title.toLowerCase.contains(p.title.toLowerCase))
      .filter(p ⇒ author.trim.isEmpty  || author.toLowerCase.contains(p.author.toLowerCase))
      .toSeq
  }

  def findPosts(filter: PostFilter): Seq[Post] = findPosts(PostFilter(
    filter.beforeDate,
    filter.afterDate,
    filter.content,
    filter.title,
    filter.author,
    filter.limit,
    filter.page
  ))
}
