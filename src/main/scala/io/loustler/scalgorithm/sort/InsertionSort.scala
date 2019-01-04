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

import io.loustler.scalgorithm.utils.DetermineUtils

/**
  * @author loustler
  * @since 0.0.1
  */
object InsertionSort {

  def sort[T: Ordering](array: Array[T]): Unit =
    sort(array, 0, array.length, implicitly[Ordering[T]])

  def sort[T](array: Array[T], start: Int, finish: Int, ord: Ordering[T]): Unit = {
    val n = finish - start
    if (n < 2) return

    // swap start and next index from start if next index grater than start
    if (ord.gt(array(start), array(start + 1))) {
      val temp: T = array(start)
      array(start)     = array(start + 1)
      array(start + 1) = temp
    }
    var m: Int = 2

    while (m < n) {
      val next: T = array(start + m)
      if (ord.lt(next, array(start + m - 1))) {
        var i = start
        var j = start + m - 1

        while (j - i > 1) {
          val idx: Int = DetermineUtils.pivot(i, j)

          if (ord.lt(next, array(idx))) j = idx
          else i                          = idx
        }

        val idx: Int = i + (if (ord.lt(next, array(i))) 0 else 1)
        var k:   Int = start + m

        while (k > idx) {
          array(k) = array(k - 1)
          k -= 1
        }
        array(idx) = next
      }
      m += 1
    }
  }
}
