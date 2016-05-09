package com.jshin47.jtdc.dto

case class NavigationItem(id: String, url: String, title: String)
case class NavigationItems(navigationItems: Seq[NavigationItem])
case class Masthead(
                     navigationItems: NavigationItems,
                     siteTitle: String,
                     siteByline: String,
                     active: Boolean
                   )