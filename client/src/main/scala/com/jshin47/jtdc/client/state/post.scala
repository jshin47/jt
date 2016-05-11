package com.jshin47.jtdc.client.state

import com.jshin47.jtdc.cmd.Cmd
import com.jshin47.jtdc.dto.{Post, PostFilter, Posts}
import diode.data.{PendingStale, Pot, PotAction}

case class FindPosts(filter: PostFilter, potResult: Pot[Posts]) extends PotAction[Posts, FindPosts] with Cmd {
  override def next(newResult: Pot[Posts]): FindPosts =
    FindPosts(filter, potResult)
}

case class RefreshPost(oldPost: Post, potResult: Pot[Post]) extends PotAction[Posts, RefreshPost] with Cmd {
  override def next(newResult: Pot[Posts]): RefreshPost =
    RefreshPost(oldPost, potResult)
}