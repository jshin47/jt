package com.jshin47.jtdc.dto

case class NavigationItem(id: String, url: String, title: String) extends Dto
case class NavigationItems(navigationItems: Seq[NavigationItem]) extends Dto
case class Masthead(
                     navigationItems: NavigationItems,
                     siteTitle: String,
                     siteByline: String,
                     active: Boolean
                   ) extends Dto