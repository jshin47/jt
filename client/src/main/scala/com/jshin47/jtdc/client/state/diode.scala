package com.jshin47.jtdc.client.state

sealed trait DiodeSplashEffect
case object ToolipSplash extends DiodeSplashEffect

sealed trait DiodeDebugAction

sealed trait DiodeDebugLifecycleAction extends DiodeDebugAction
case class DiodeDebugDispatch(action: AnyRef, msg: String = "") extends DiodeDebugLifecycleAction
case class DiodeDebugActionResult(action: AnyRef, msg: String = "") extends DiodeDebugLifecycleAction

case class LogDiode(log: String) extends DiodeDebugAction
case class SplashDiode(log: 1String, effect: DiodeSplashEffect = ToolipSplash) extends DiodeDebugAction