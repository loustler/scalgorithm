package io.loustler.scalgorithm.basic
import scala.annotation.tailrec

/**
  * @author loustler
  * @since 0.0.1
  */
object Fibonacci {

  def recursive(number: Int): Int = number match {
    case 0 | 1 => number
    case _     => recursive(number - 1) + recursive(number - 2)
  }

  def inner(number: Int): Int = {
    def innerRecursive(number: Int): Int = number match {
      case 0 | 1 => number
      case _     => innerRecursive(number - 1) + innerRecursive(number - 2)
    }

    innerRecursive(number)
  }

  def effectiveRecursive(number: Int): Int = effectiveRecursive(number, 1, 0)

  @tailrec
  def effectiveRecursive(number: Int, eax: Int, ebx: Int): Int = {
    val realNumber: Int = number - 1

    realNumber match {
      case 0 => eax + ebx
      case _ => effectiveRecursive(realNumber, ebx, eax + ebx)
    }
  }
}
