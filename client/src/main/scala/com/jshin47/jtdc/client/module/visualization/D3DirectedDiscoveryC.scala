package com.jshin47.jtdc.client.module.visualization

import japgolly.scalajs.react.BackendScope


object D3DirectedDiscoveryC {

  object Parts {

    case class Node(
                     id: String,
                     description: String
                   ) {
      def toTreeNode = new TreeNode(id, description)

    }

    case class Edge(
                     parentId: String,
                     childId: String,
                     flags: String
                   )

    trait NodeMapper[T] {
      def mapNode(t: T): Node
      def mapChildren(t: T, nodes: Seq[Node]): Seq[Node]
      def mapParent(t: T, nodes: Seq[Node]): Node
    }

    class TreeNode(
                         id: String,
                         description: String,
                         val parent: Option[Node] = None,
                         val children: Seq[Node] = Seq()
                       ) extends Node(id, description) {



    }

  }

  case class Props(
                    abra: String
                  )

  type State = Unit

  class Backend($: BackendScope[Props, State]) {

    def render(p: Props, s: State): Unit = {

    }

  }

}
