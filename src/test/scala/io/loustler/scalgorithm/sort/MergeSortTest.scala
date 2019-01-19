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

import io.loustler.scalgorithm.BaseTest
import io.loustler.scalgorithm.sort.MergeSort._

/**
  * @author loustler
  * @since 0.0.1
  */
class MergeSortTest extends BaseTest {
  "MergeSort" should "be success" in {
    val array: List[Int] = List(14, 13, 16, 21, 15, 8, 36, 21, 12, 20, 22, 35, 13, 45, 43, 17, 19,
      18, 28, 40, 30, 25, 41, 30, 52, 57, 26, 30, 38, 48, 50, 52, 44, 60)
    val expected: List[Int] =
      List(8, 12, 13, 13, 14, 15, 16, 17, 18, 19, 20, 21, 21, 22, 25, 26, 28, 30, 30, 30, 35, 36,
        38, 40, 41, 43, 44, 45, 48, 50, 52, 52, 57, 60)

    measure(sort[Int](array)(_ < _)) shouldBe expected
  }

  it should "be success 2" in {
    val stringList: List[String] = List("1", "11", "1111", "111", "11111")

    val expected: List[String] = stringList.sortBy(_.length)

    measure(sort(stringList)(_.length < _.length)) shouldBe expected
  }

  it should "be success version 2" in {
    val array: Array[Int] = Array(14, 13, 16, 21, 15, 8, 36, 21, 12, 20, 22, 35, 13, 45, 43, 17, 19,
      18, 28, 40, 30, 25, 41, 30, 52, 57, 26, 30, 38, 48, 50, 52, 44, 60)
    val expected: Array[Int] =
      Array(8, 12, 13, 13, 14, 15, 16, 17, 18, 19, 20, 21, 21, 22, 25, 26, 28, 30, 30, 30, 35, 36,
        38, 40, 41, 43, 44, 45, 48, 50, 52, 52, 57, 60)

    measure(sort2(array))

    array shouldBe expected
  }
}
