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
import io.loustler.scalgorithm.sort.MergeSort.sort

/**
  * @author loustler
  * @since 0.0.1
  */
class MergeSortTest extends BaseTest {
  "MergeSort" should "be success" in {
    val intList: List[Int] = List(6, 3, 7, 2, 4, 1, 9, 0, 5, 8)

    val expected: List[Int] = intList.sorted

    sort(intList)(_ < _) shouldBe expected
  }

  it should "be success 2" in {
    val stringList: List[String] = List("1", "11", "1111", "111", "11111")

    val expected: List[String] = stringList.sortBy(_.length)

    sort(stringList)(_.length < _.length) shouldBe expected
  }
}
