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

package io.loustler.scalgorithm.search

import scala.annotation.tailrec

/**
  * @author loustler
  * @since 0.0.1
  */
object BinarySearch {

  def search(arr: Array[Int], x: Int): Int = {
    @tailrec
    def recursive(arr: Array[Int], x: Int, start: Int, finish: Int): Int =
      if (start <= finish) {
        val pivot: Int = (start + finish) / 2

        if (x == arr(pivot)) pivot
        else {
          if (x < arr(pivot)) recursive(arr, x, start, pivot - 1)
          else recursive(arr, x, pivot + 1, finish)
        }
      } else -1

    recursive(arr, x, 0, arr.length - 1)
  }
}
