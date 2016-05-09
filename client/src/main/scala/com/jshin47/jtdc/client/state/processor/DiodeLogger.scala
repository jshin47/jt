package com.jshin47.jtdc.client.state.processor

import diode.{ActionProcessor, ActionResult, Dispatcher}

/**
  * Created by justin on 5/9/16.
  */
class DiodeLogger[M <: AnyRef] extends ActionProcessor[M] {
  override def process(
                        dispatch: Dispatcher,
                        action: AnyRef,
                        next: (AnyRef) ⇒ ActionResult[M],
                        currentModel: M
                      ): ActionResult[M] = {

    def ld_model(pre: String, model: M) = s"$pre: ${model.toString}"

    val ld_previous1 = s"previous state: ${currentModel.toString}"
    val ld_action2   = s"action: ${action.toString}"
    val ld_nochange  = s"No change"
    val ld_effect    = s"effect only"
    val ld_unknown   = s"Unknown action result"

    val result       = next(action)

    result match {
      case ActionResult.NoChange ⇒ println(ld_nochange)
      case ActionResult.EffectOnly(_) ⇒ println(ld_effect)
      case ActionResult.ModelUpdate(newModel) ⇒ println(ld_model("Next state", newModel))
      case ActionResult.ModelUpdateEffect(newModel, _) ⇒ println(ld_model("Next state", newModel))
      case _ ⇒ println(ld_unknown)
    }

    result
  }
}
