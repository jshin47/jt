package com.jshin47.jtdc.client.module.post

import chandu0101.scalajs.react.components.materialui.MuiTextField
import com.jshin47.jtdc.client.state.{AddPost, PostFilter}
import com.jshin47.jtdc.dto.{Post, PostId, Posts}
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

object PostC {

  case class Props(
                    onDelete: Callback,
                    onStartEditing: Callback,
                    onUpdateTitleAndContent: (String, String) ⇒ Callback,
                    onCancelEditing: Callback,
                    post: Post,
                    isEditing: Boolean
                  )

  case class State(titleEditText: String, contentEditText: String)

  class Backend($: BackendScope[Props, State]) {
    val x = $.props.map(_.isEditing)

    def editFieldSubmit(p: Props): Callback =
      $.state.flatMap(s =>
        if (s.titleEditText.trim == "" && s.contentEditText.trim == "")
          p.onDelete
        else
          p.onUpdateTitleAndContent(s.titleEditText, s.contentEditText)
      )

    def resetText(p: Props): Callback =
      $.modState(_.copy(titleEditText = p.post.title, contentEditText = p.post.content))

    def editFieldKeyDown(p: Props): ReactKeyboardEvent ⇒ Callback =
      e ⇒ e.nativeEvent.keyCode match {
        case KeyCode.Escape => resetText(p) >> p.onCancelEditing
        case KeyCode.Enter => editFieldSubmit(p)
        case _ ⇒ Callback{}
      }

    val titleFieldChanged: ReactEventI ⇒ Callback =
      e ⇒ {
        println(e)
        println(e.target.value)
        println(e.currentTarget.value)
        val value = e.target.value
        if (e.target != null)
          $.modState(s ⇒ s.copy(titleEditText = value))
        else
          $.modState(s ⇒ s)
      }

    val contentEditChanged: ReactEventI ⇒ Callback =
      e ⇒ {
        println(e)
        println(e.target.value)
        println(e.currentTarget.value)
        val value = e.target.value
        if (e.target != null)
          $.modState(s ⇒ s.copy(contentEditText = value))
        else
          $.modState(s ⇒ s)
      }

    def render(p: Props, s: State): ReactElement =
      <.li(
      ^.classSet(
        "editing" → p.isEditing
      ),
      <.div(
        ^.className := "view",
        <.label(
          p.post.title,
          ^.key := s"${p.post.id}-post-title",
          ^.onDoubleClick --> p.onStartEditing
        ),
        <.span(
          p.post.content,
          ^.key := s"${p.post.id}-post-content",
          ^.onDoubleClick --> p.onStartEditing
        ),
        <.button(
          ^.className := "destroy",
          ^.onClick --> p.onDelete
        ),
        MuiTextField(
          onBlur = (e: ReactEventI) ⇒ editFieldSubmit(p),
          onChange = titleFieldChanged,
          onKeyDown = editFieldKeyDown(p),
          value = s.titleEditText
        )(),
        MuiTextField(
          onBlur = (e: ReactEventI) ⇒ editFieldSubmit(p),
          onChange = contentEditChanged,
          onKeyDown = editFieldKeyDown(p),
          value = s.contentEditText,
          multiLine = true
        )()
      )
    )

  }

  val component = ReactComponentB[Props]("PostItem")
    .initialState_P(p ⇒ State(p.post.title, p.post.content))
    .renderBackend[Backend]
    .build

  def apply(P: Props) =
    component.withKey(P.post.id.id.toString)(P)

}
