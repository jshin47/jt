package com.jshin47.jtdc.client.module.visualization

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.{JSExport, JSFullName, JSName, ScalaJSDefined}

@js.native
@JSName("react2tree")
object react2tree extends js.Any {
  @JSName("default")
  def apply(anything: js.Any): js.Dynamic = js.native
}

@JSExport("TreeRootFactory")
object TreeRoot {

  var i = 0
  def nextInt() = {
    i += 1
    i
  }

}

@JSExport("TreeNode")
case class TreeNode(
                     id: Int                           = TreeRoot.nextInt(),
                     name: String                      = "Example",
                     depth: Int                        = 0,
                     parent: Option[TreeNode]          = None,
                     state: Option[Array[TreeNode]] = None
                   ) {

  def addChild(
                _name: String                          = "ChildExample",
                _children: Option[Array[TreeNode]]     = None,
                _id: Int                               = TreeRoot.nextInt()
              ): TreeNode = {

    val newNode =
      TreeNode(
        _id,
        _name,
        depth = this.depth + 1,
        parent = Some(this),
        state = _children
      )

    TreeNode(
      this.id,
      this.name,
      this.depth,
      this.parent,
      this.state match {
        case Some(c) ⇒ Some(c :+ newNode)
        case None ⇒ Some(Array(newNode))
      }
    )
  }

}

object Examples {
  @JSExport
  val root = TreeNode(name = "Root").addChild(
    "Child 1"
  ).addChild("Child 2").addChild("Child 3")
}
