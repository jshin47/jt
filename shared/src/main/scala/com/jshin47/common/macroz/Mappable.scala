package com.jshin47.common.macroz

import scala.language.experimental.macros

trait MappableModel

object MappableModel {
  implicit class Mappable[M <: MappableModel](val model: M) extends AnyVal {
    def asMap: Map[String, Any] = macro Macros.asMap_impl[M]
  }

  private object Macros {
    import scala.reflect.macros.whitebox.Context

    def asMap_impl[T: c.WeakTypeTag](c: Context) = {
      import c.universe._

      val mapApply = Select(reify(Map).tree, TermName("apply"))
      val model = Select(c.prefix.tree, TermName("model"))

      val pairs = weakTypeOf[T].decls.collect {
        case m: MethodSymbol if m.isCaseAccessor =>
          val name = c.literal(m.name.decoded)
          val value = c.Expr(Select(model, m.name))
          reify(name.splice -> value.splice).tree
      }

      c.Expr[Map[String, Any]](Apply(mapApply, pairs.toList))
    }
  }
}