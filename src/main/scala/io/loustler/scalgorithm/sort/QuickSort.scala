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

import scala.math.Ordering

/**
  * @author loustler
  * @since 0.0.1
  */
object QuickSort {
  private final val threshold: Int = 16

  def sort[K: Ordering](array: Array[K]): Unit = {
    // Must have finish >= start or math will fail. Also, start >= 0
    def inner(array: Array[K], start: Int, finish: Int, ord: Ordering[K]): Unit =
      if (finish - start < threshold) InsertionSort.sort(array, start, finish, ord)
      else {
        val k: Int = DetermineUtils.pivot(start, finish)

        var left: Int =
          if (ord.lteq(array(start), array(finish - 1))) // if first element <= latest element
            if (ord.lt(array(start), array(k))) // if first element < middle element
              // if latest element < middle element
              if (ord.lt(array(finish - 1), array(k))) finish - 1
              else k
            else start
          else { // if latest elements < first element
            if (ord.lt(array(start), array(k))) start
            else {
              if (ord.lteq(array(finish - 1), array(k))) start - 1
              else k
            }
          }

        val pivot: K = array(left)

        if (left != k) {
          array(left) = array(k)
          array(k)    = pivot
          left = k
        }

        var right: Int = left + 1

        var iA: Int = start
        var iB: Int = finish

        while (left - iA > 0) {
          val current: K = array(iA)
          ord.compare(current, pivot) match {
            case 0 => // if same
              array(iA)       = array(left - 1)
              array(left - 1) = current
              left -= 1

            case x if x < 0 =>
              iA += 1
            case _ if iB > right =>
              array(iA)     = array(iB - 1)
              array(iB - 1) = current
              iB -= 1
            case _ =>
              array(iA)        = array(left - 1)
              array(left - 1)  = array(right - 1)
              array(right - 1) = current
              left -= 1
              right -= 1
              iB -= 1
          }
        }
        while (iB - right > 0) {
          val current = array(iB - 1)
          ord.compare(current, pivot) match {
            case 0 =>
              array(iB - 1) = array(right)
              array(right)  = current
              right += 1
            case x if x > 0 =>
              iB -= 1
            case _ =>
              array(iB - 1) = array(right)
              array(right)  = array(left)
              array(left)   = current
              iA += 1
              left += 1
              right += 1
          }
        }

        if (iA - start < finish - iB) {
          inner(array, start, iA, ord)
          inner(array, iB, finish, ord)
        } else {
          inner(array, iB, finish, ord)
          inner(array, start, iA, ord)
        }
      }

    inner(array, 0, array.length, implicitly[Ordering[K]])
  }
}
