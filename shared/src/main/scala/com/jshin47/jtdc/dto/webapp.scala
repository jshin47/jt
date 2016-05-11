package com.jshin47.jtdc.dto

case class Masthead(
                     navigationItems: NavigationItems,
                     siteTitle: String,
                     siteByline: String,
                     active: Boolean
                   ) extends Dto

case class BackgroundAndPortfolio(

                                 ) extends Dto