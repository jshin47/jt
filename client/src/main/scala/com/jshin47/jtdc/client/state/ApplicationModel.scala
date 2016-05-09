package com.jshin47.jtdc.client.state

import com.jshin47.jtdc.dto.{Masthead, Posts}


case class ApplicationModel(
                             posts: Posts,
                             masthead: Masthead
                           )