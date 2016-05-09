package com.jshin47.jtdc.client.state.handler

import com.jshin47.jtdc.client.state.MastheadIsActive
import com.jshin47.jtdc.dto.Masthead
import diode.{ActionHandler, ActionResult, ModelRW}

class MastheadHandler[M](modelRW: ModelRW[M, Masthead]) extends ActionHandler(modelRW) {

  override protected def handle: PartialFunction[AnyRef, ActionResult[M]] = {

    case MastheadIsActive(isActive) ⇒
      updated(value.copy(active = isActive))
    case _ ⇒ {
      println("cannot handle")
      throw new NotImplementedError()
    }
  }

}
