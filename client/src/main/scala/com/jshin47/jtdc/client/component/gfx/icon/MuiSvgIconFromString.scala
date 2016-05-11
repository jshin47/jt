package com.jshin47.jtdc.client.component.gfx.icon

import com.jshin47.jtdc.client.component.gfx.icon.MuiSvgIcons.SocialNotifications

/**
  * Created by justin on 5/10/16.
  */
object MuiSvgIconFromString {

  def apply(icon: String) = icon match {
    case social if social.startsWith("SocialNotification") ⇒
      SocialNotifications()
    case _ ⇒ null

  }

}
