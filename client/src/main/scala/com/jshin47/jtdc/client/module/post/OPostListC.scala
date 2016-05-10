package com.jshin47.jtdc.client.module.post

import chandu0101.scalajs.react.components.materialui._
import com.jshin47.jtdc.client.state._
import com.jshin47.jtdc.dto._
import japgolly.scalajs.react.extra.router._
import diode.react.ModelProxy
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.ext.KeyCode
import chandu0101.scalajs.react.components.Implicits._

object OPostListC {

  case class Props(proxy: ModelProxy[Posts], filter: PostFilter, ctl: RouterCtl[PostFilter])
  case class State(editing: Option[PostId], currentTitle: String, currentPost: String)

  class Backend($: BackendScope[Props, State]) {

    def mounted(props: Props) = Callback {}

    def newTitleFieldChanged: ReactEventI ⇒ Callback =
      e ⇒ {
        val value = e.target.value
        if (e.target != null) {
          $.modState(s ⇒ s.copy(currentTitle = value))
        } else {
          $.modState(s ⇒ s)
        }
      }

    def newContentFieldChanged: ReactEventI ⇒ Callback =
      e ⇒ {
        val value = e.target.value
        if (e.target != null) {
          $.modState(s ⇒ s.copy(currentPost = value))
        } else {
          $.modState(s ⇒ s)
        }
      }

    def createFieldKeyDown(p: Props): ReactKeyboardEvent ⇒ Callback =
      e ⇒ e.nativeEvent.keyCode match {
        case KeyCode.Enter => createFieldSubmit(p)
        case _ ⇒ Callback{}
      }

    def createFieldSubmit(p: Props): Callback = {
      $.state.flatMap(s ⇒ p.proxy.dispatch(AddPost(s.currentTitle, s.currentPost)))
    }

    def editingDone(): Callback =
      $.modState(_.copy(editing = None))

    val startEditing: PostId ⇒ Callback =
      id ⇒ $.modState(_.copy(editing = Some(id)))

    def render(p: Props, s: State) = {
      val proxy = p.proxy()
      val dispatch = p.proxy.dispatch
      val posts = proxy.postList
      val filteredPosts = posts filter p.filter.predicate

      <.div(^.display.flex, ^.flexDirection.column,
        <.h1("Posts"),
        MuiTextField(
          key = "title",
          floatingLabelText = "Start entering a title",
          onChange = newTitleFieldChanged,
          onKeyDown = createFieldKeyDown(p))(),
        MuiTextField(
          key = "content",
          floatingLabelText = "Enter post content",
          onChange = newContentFieldChanged,
          onKeyDown = createFieldKeyDown(p))(),
        posts.nonEmpty ?= postList(dispatch, s.editing, filteredPosts)
      )

    }

    def postList(dispatch: AnyRef ⇒ Callback, editing: Option[PostId], posts: Seq[Post]) =
      <.section(
        ^.className := "main",
        <.ul(
          ^.className := "post-list",
          posts.map(post ⇒
            PostC(
              PostC.Props(
                onCancelEditing = editingDone(),
                onDelete = dispatch(DeletePost(post.id)),
                onStartEditing = startEditing(post.id),
                onUpdateTitleAndContent = (title, content) ⇒ dispatch(UpdatePost(post.id, Some(title), Some(content))) >> editingDone(),
                post = post,
                isEditing = editing.contains(post.id)
              )
            )
          )
        )
      )

  }

  private val component = ReactComponentB[Props]("PostList")
    .initialState_P(p ⇒ State(None, "", ""))
    .renderBackend[Backend]
    .componentDidMount(scope ⇒ scope.backend.mounted(scope.props))
    .build

  def apply(proxy: ModelProxy[Posts], currentFilter: PostFilter, ctl: RouterCtl[PostFilter]) = component(Props(proxy, currentFilter, ctl))

}
