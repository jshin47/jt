package com.jshin47.jtdc.client.component.layout.parallax

import chandu0101.scalajs.react.components.materialui.MuiTextField
import com.jshin47.jtdc.dto.{Post, ContentItem, Posts}
import diode.react.ModelProxy
import japgolly.scalajs.react.{BackendScope, Callback}
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router._
import diode.react.ModelProxy
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.ext.KeyCode
import chandu0101.scalajs.react.components.Implicits._

import scala.scalajs.js

object SkrollrFacade {

  case class SkrollrFInstance(
                               var initParameters: js.WrappedDictionary[js.Any] = js.WrappedDictionary.empty
                             ) {

    def initSkrollr() = SkrollrF.init(initParameters)

    def addRender(renderFunc: js.Function1[js.Any, js.Any]): SkrollrFInstance = {
      initParameters.put("render", renderFunc)
      this
    }

    def keyframe(kFunc: js.Function3[js.Any, String, js.Any, js.Any]): SkrollrFInstance = {
      initParameters.put("keyframe", kFunc)
      this
    }

    def smooth(smoothe: Boolean = true, duration: Int = 200): SkrollrFInstance = {
      initParameters.put("smoothScrolling", smoothe)
      initParameters.put("smoothScrollingDuration", duration)
      this
    }

    def forceHeight(force: Boolean = true): SkrollrFInstance = {
      initParameters.put("forceHeight", force)
      this
    }

  }

  def mkAttrForAbsolute(
                         isStart: Boolean      = true,   // otherwise end
                         offset:  Option[Int]  = None
                       ) = {

    val offsetMod = offset match {
      case Some(o) ⇒ s"-$o"
      case None ⇒ ""
    }

    val start = if (isStart) "start" else "end"

    s"data$offsetMod-$start".reactAttr
  }

  sealed trait RelViewportOrElAnchor
  abstract class VOREA(toStringy: String) extends RelViewportOrElAnchor { override def toString: String = toStringy }
  case object Top extends VOREA("top")
  case object Center extends VOREA("center")
  case object Bottom extends VOREA("bottom")

  def mkAttrForAnchorRel(
                          viewportPosition: RelViewportOrElAnchor,
                          elPosition:       Option[RelViewportOrElAnchor] = None,
                          offset:           Option[Int]                   = None
                     ) = {

    val realElPosition = elPosition.getOrElse(viewportPosition)

    val offsetMod = offset match {
      case Some(o) ⇒ s"-$o"
      case None ⇒ ""
    }

    s"data$offsetMod-$viewportPosition-$realElPosition".reactAttr
  }

  object Attrs {
    val dataAbsoluteStart                                                       = mkAttrForAbsolute(true)
    val dataAbsoluteStartPlus5Grand                                             = mkAttrForAbsolute(true, Some(5000))
    val dataAbsoluteEnd                                                         = mkAttrForAbsolute(false)

    val dataAtStart0                                                            = mkAttrForAbsolute(true, Some(0))
    val dataAtStart500                                                          = mkAttrForAbsolute(true, Some(500))

    val dataRelTopOfTop                                                         = mkAttrForAnchorRel(Top)
    val dataRelCenterOfTop                                                      = mkAttrForAnchorRel(Top, Some(Center))
    val dataRelBottomOfTop                                                      = mkAttrForAnchorRel(Top, Some(Bottom))
    val dataRelTopOfCenter                                                      = mkAttrForAnchorRel(Center, Some(Top))
    val dataRelCenterOfCenter                                                   = mkAttrForAnchorRel(Center, Some(Center))
    val dataRelBottomOfCenter                                                   = mkAttrForAnchorRel(Center, Some(Bottom))
    val dataRelTopOfBottom                                                      = mkAttrForAnchorRel(Bottom, Some(Top))
    val dataRelCenterOfBottom                                                   = mkAttrForAnchorRel(Bottom, Some(Center))
    val dataRelBottomOfBottom                                                   = mkAttrForAnchorRel(Bottom, Some(Bottom))

    val dataRel500pxScrolledDown                                                = mkAttrForAnchorRel(Top, Some(Top), Some(500))
    val dataRel1000pxScrolledDown                                               = mkAttrForAnchorRel(Top, Some(Top), Some(1000))
    val dataRel1500pxScrolledDown                                               = mkAttrForAnchorRel(Top, Some(Top), Some(1500))
    val dataRel2000pxScrolledDown                                               = mkAttrForAnchorRel(Top, Some(Top), Some(2000))
  }



}