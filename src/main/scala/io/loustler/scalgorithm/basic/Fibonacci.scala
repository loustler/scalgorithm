package io.loustler.scalgorithm.basic
import scala.annotation.tailrec

/**
  * @author loustler
  * @since 0.0.1
  */
object Fibonacci {

  def recursive(number: Int): Long = number match {
    case 0 | 1 => number
    case _     => recursive(number - 1) + recursive(number - 2)
  }

  def inner(number: Int): Long = {
    def innerRecursive(number: Int): Int = number match {
      case 0 | 1 => number
      case _     => innerRecursive(number - 1) + innerRecursive(number - 2)
    }

    innerRecursive(number)
  }

  def effectiveRecursive(number: Int): Long = effectiveRecursive(number, 1, 0)

  @tailrec
  def effectiveRecursive(number: Int, eax: Int, ebx: Int): Long = {
    val realNumber: Int = number - 1

    realNumber match {
      case 0 => eax + ebx
      case _ => effectiveRecursive(realNumber, ebx, eax + ebx)
    }
  }

  def iteractive(number: Int): Long = {
    var i:    Long = 0L
    var j:    Long = 1L
    var temp: Long = 0L

    for (nothing <- number until 2 by -1) {
      temp = i
      i    = j
      j    = j + temp
    }

    i + j
  }
}
