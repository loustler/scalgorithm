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

/**
  * @author loustler
  * @since 0.0.1
  */
object MergeSort {

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
}
