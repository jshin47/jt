package com.jshin47.jtdc.client.state

import com.jshin47.jtdc.dto.{Masthead, Posts}
import com.jshin47.macroz.MappableModel


case class ApplicationModel(
                             posts: Posts,
                             masthead: Masthead
                           ) extends MappableModel