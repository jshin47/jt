package com.jshin47.jtdc.dto

import java.time.{LocalDate, ZonedDateTime}
import java.util.UUID

case class ContentItem(id: UUID) extends Dto

object ContentItem {
  def generate = new ContentItem(UUID.randomUUID())
}

case class ContentItems(items: Seq[ContentItem]) extends Dto {
  //def this(ids: Seq[String]) = this(ids.map(i ⇒ new ContentItem(UUID.fromString(i))))
}
