package com.jshin47.jtdc.dto

case class Tag(
                label: String,
                items: ContentItems,
                related: Tags,
                item: ContentItem = ContentItem.generate
              ) extends Dto

case class Tags(seq: Seq[Tag]) extends Dto

case class TaggedPosts(
                        label: String,
                        posts: Posts
                      ) extends Dto
