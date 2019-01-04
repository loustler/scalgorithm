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
import io.loustler.scalgorithm.sort.InsertionSort.sort

/**
  * @author loustler
  * @since 01/04/2019
  */
class InsertionSortTest extends BaseTest {
  "InsertionSort" should "be success for String array" in {
    val array:    Array[String] = Array("A", "a", "b", "ABC", "c")
    val expected: Array[String] = Array("A", "ABC", "a", "b", "c")

    measure(sort(array))

    array shouldBe expected
  }

  it should "be success for Int array" in {
    val array:    Array[Int] = Array(1, 3, 5, 2, 4, 6, 7, 8)
    val expected: Array[Int] = 1 to 8 toArray

    measure(sort(array))

    array shouldBe expected
  }

  it should "be success for Long array" in {
    val array:    Array[Long] = Array(1L, 5L, 4L, 3L, 2L, 6L, 7L, 8L)
    val expected: Array[Long] = (1 to 8).toArray.map(_.toLong)

    measure(sort(array))

    array shouldBe expected
  }
}
