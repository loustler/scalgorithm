/*
 * Copyright (c) 2019 DONGYEON LEE(aka loustler)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package io.loustler.scalgorithm.sort
import scala.math.Ordering
import scala.reflect.ClassTag

/**
  * @author loustler
  * @since 0.0.1
  */
object MergeSort {
  private final val threshold = 32

  def sort[T](xs: List[T])(less: (T, T) => Boolean): List[T] = {
    def merge1(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, _)             => ys
      case (_, Nil)             => xs
      case (x :: xsl, y :: ysl) => if (less(x, y)) x :: merge1(xsl, ys) else y :: merge1(xs, ysl)
    }

    val n: Int = xs.length / 2
    if (n == 0) xs
    else {
      val (xz: List[T], yz: List[T]) = xs splitAt n
      merge1(sort(xz)(less), sort(yz)(less))
    }
  }

  def sort2[T: ClassTag](array: Array[T])(implicit ord: Ordering[T]): Unit = {
    def inner(array:   Array[T],
              i0:      Int,
              iN:      Int,
              ord:     Ordering[T],
              scratch: Array[T] = Array.empty[T]): Unit =
      if (iN - i0 < threshold) InsertionSort.sort(array, i0, iN, ord)
      else {
        val iK = (i0 + iN) >>> 1 // Bit shift equivalent to unsigned math, no overflow
        val sc = if (scratch.isEmpty) new Array[T](iK - i0) else scratch
        inner(array, i0, iK, ord, sc)
        inner(array, iK, iN, ord, sc)
        sorted(array, i0, iK, iN, ord, sc)
      }

    inner(array, 0, array.length, ord)
  }

  private def sorted[T](array:   Array[T],
                        i0:      Int,
                        iK:      Int,
                        iN:      Int,
                        ord:     Ordering[T],
                        scratch: Array[T]): Unit =
    // Check to make sure we're not already in order
    if (ord.compare(array(iK - 1), array(iK)) > 0) {
      var i  = i0
      val jN = iK - i0
      var j  = 0
      while (i < iK) {
        scratch(j) = array(i)
        i += 1
        j += 1
      }
      var k = i0
      j = 0
      while (i < iN && j < jN) {
        if (ord.compare(array(i), scratch(j)) < 0) {
          array(k) = array(i)
          i += 1
        } else {
          array(k) = scratch(j)
          j += 1
        }
        k += 1
      }
      while (j < jN) { array(k) = scratch(j); j += 1; k += 1 }
      // Don't need to finish a(i) because it's already in place, k = i
    }
}
