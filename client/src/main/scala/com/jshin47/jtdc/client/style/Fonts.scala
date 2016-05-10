package com.jshin47.jtdc.client.style

import java.net.URLEncoder

import com.jshin47.jtdc.client.style.fonts.NormalStyle

import scalacss.Defaults._
import scalacss.{FontFace ⇒ FF}

/**
  * Created by justin on 5/10/16.
  */
object fonts extends StyleSheet.Inline {

  import dsl._

  trait FontDefinition {
    def toFontFace: FF
  }

  sealed trait FonStyle {
    def configureStyle(ff: FF): FF
    def apply(ff: FF) = configureStyle(ff)
    override def toString: String = ""
  }

  case object NormalStyle extends FonStyle {
    override def configureStyle(ff: FF): FF = ff.fontStyle.normal
  }

  case object ObliqueStyle extends FonStyle {
    override def configureStyle(ff: FF): FF = ff.fontStyle.oblique
    override def toString: String = "bold"
  }

  case object ItalicizedStyle extends FonStyle {
    override def configureStyle(ff: FF): FF = ff.fontStyle.italic
    override def toString: String = "italic"
  }

  sealed trait FontStrength {
    def configureWeight(ff: FF): FF
    def apply(ff: FF) = configureWeight(ff)
  }

  case object NormalStrength extends FontStrength {
    override def configureWeight(ff: FF): FF = ff.fontWeight.normal
  }

  case class NumericStrengthAndStyle(hundreds: Int, style: FonStyle) extends FontStrength with FonStyle {

    override def configureWeight(ff: FF): FF = math.round(hundreds / 100.0) match {
      case 0 ⇒ ff.fontWeight._100
      case 1 ⇒ ff.fontWeight.normal
      case 2 ⇒ ff.fontWeight._200
      case 3 ⇒ ff.fontWeight._300
      case 4 ⇒ ff.fontWeight._400
      case 5 ⇒ ff.fontWeight._500
      case 6 ⇒ ff.fontWeight._600
      case 7 ⇒ ff.fontWeight._700
      case 8 ⇒ ff.fontWeight._800
      case 9 ⇒ ff.fontWeight._900
    }


    override def configureStyle(ff: FF): FF = style.configureStyle(ff)
    override def apply(ff: FF): FF = configureStyle(ff)
  }

  sealed trait FontKerning {
    def configureStretch(ff: FF): FF
    def apply(ff: FF) = configureStretch(ff)
  }

  case object NormalKerning extends FontKerning {
    override def configureStretch(ff: FF): FF = ff.fontStretch.normal
  }

  implicit class FFExtended(ff: FF) {
    def useKerning(kerning: FontKerning): FF = kerning(ff)
    def useStrength(strength: FontStrength): FF = strength(ff)
  }

  case class FontDefBuilder(
                             family: String,
                             sourcez: (FontDefBuilder) ⇒ String = (FontDefBuilder) ⇒ "local",
                             stylez: FonStyle = NormalStyle,
                             kerning: FontKerning = NormalKerning,
                             weight: FontStrength = NormalStrength
                      ) extends FontDefinition {

    override def toFontFace: FF =
      fontFace(fontFamily = family)(
        _.src(src = sourcez(this))
          .useKerning(kerning)
          .useStrength(weight)
      )

    def withStyle(l: FonStyle): FontDefBuilder = this.copy(stylez = l)
    def withSource(s: String): FontDefBuilder = this.copy(sourcez = (ff) ⇒ s)
    def withSource(str: (FontDefBuilder) ⇒ String): FontDefBuilder = this.copy(sourcez = str)
    def withKerning(k: FontKerning) = this.copy(kerning = k)
    def withWeight(w: FontStrength) = this.copy(weight = w)

  }

  object Google {

    def url(family: String): String = s"https://fonts.googleapis.com/css?family=${family.replace(' ', '+')}"
    def url(family: String, weightedStyle: NumericStrengthAndStyle): String = s"${url(family)}: ${weightedStyle.hundreds}${weightedStyle.style.toString}"

    def base(family: String): FontDefBuilder
      = FontDefBuilder(family, ff ⇒ url(ff.family))

    def base(family: String, weightedStyle: NumericStrengthAndStyle): FontDefBuilder
      = new FontDefBuilder(family, ff ⇒ url(ff.family, weightedStyle), weightedStyle, NormalKerning, weightedStyle)

  }

}

object WebFonts{
  import com.jshin47.jtdc.client.style.fonts.NumericStrengthAndStyle
  import com.jshin47.jtdc.client.style.fonts.Google
  import com.jshin47.jtdc.client.style.fonts.FonStyle

  case class WebFontFactory(family: String) {
    def apply(w: Int, s: FonStyle = NormalStyle): FF = Google.base(family, NumericStrengthAndStyle(w, s)).toFontFace
    def apply(): FF = Google.base(family).toFontFace
  }

  private object Families {
    val OpenSans                              = "Open Sans"
    val Roboto                                = "Roboto"
    val Oswald                                = "Oswald"
    val Slabo                                 = "Slabo"
    val Lato                                  = "Lato"
    val Montserrat                            = "Montserrat"
    val Lora                                  = "Lora"
  }

  val OpenSans = WebFontFactory(Families.OpenSans)
  val Roboto   = WebFontFactory(Families.Roboto)

}