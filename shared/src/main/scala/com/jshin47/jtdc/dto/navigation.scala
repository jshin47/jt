package com.jshin47.jtdc.dto

case class NavigationItem(
                           id: String,
                           url: String,
                           title: String,
                           current: Boolean,
                           activated: Boolean = false
                         ) extends Dto

case class NavigationItems(navigationItems: Seq[NavigationItem]) extends Dto
