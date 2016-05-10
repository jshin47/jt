package com.jshin47.jtdc.dto

sealed trait FillDto extends Dto

sealed trait ColorDto extends FillDto
case class HexColorDto(hex: String) extends ColorDto
case class RgbColorDto(r: Int, g: Int, b: Int) extends ColorDto
case class RgbAlphaDto(r: Int, g: Int, b: Int, alpha: Double) extends ColorDto

sealed trait Transformation extends Dto
case class Rotation(degrees: Int = 0) extends Dto
object NoRotation extends Rotation(0)
object FullRotation extends Rotation(360)

sealed trait TransformationMod extends Dto
case class Bounce(transformation: Transformation) extends TransformationMod

case class BackgroundColorByScrollPosition[T <: ColorDto](
                                                            colorToScrollPairs: (Int, T)*
                                                         )
extends Dto