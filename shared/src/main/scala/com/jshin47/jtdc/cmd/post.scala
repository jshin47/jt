package com.jshin47.jtdc.cmd

import com.jshin47.jtdc.dto.{ContentItem, Post}


case class CreatePost(newPost: Post) extends Cmd
case class UpdatePost(contentItem: ContentItem, newPost: Post) extends Cmd
case class DeletePost(contentItem: ContentItem) extends Cmd
case class RefreshPost(contentItem: ContentItem) extends Cmd
case class GetPostById(contentItem: ContentItem) extends Cmd