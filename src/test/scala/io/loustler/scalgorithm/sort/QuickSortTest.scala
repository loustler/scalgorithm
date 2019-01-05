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
import io.loustler.scalgorithm.sort.QuickSort.sort

/**
  * @author loustler
  * @since 0.0.1
  */
class QuickSortTest extends BaseTest {
  "QuickSort" should "be success String array" in {
    val array: Array[String] = Array(
      "Hello",
      "guys",
      "I",
      "wish",
      "you",
      "have",
      "a",
      "Good",
      "day",
      "and",
      "Happy",
      "new",
      "year",
      "Thank",
      "you",
      "From",
      "DONGYEON LEE",
      "aka loustler"
    )
    val expected: Array[String] = Array(
      "DONGYEON LEE",
      "From",
      "Good",
      "Happy",
      "Hello",
      "I",
      "Thank",
      "a",
      "aka loustler",
      "and",
      "day",
      "guys",
      "have",
      "new",
      "wish",
      "year",
      "you",
      "you"
    )

    measure(sort(array))

    array shouldBe expected
  }

  it should "be success Int array" in {
    val array: Array[Int] = Array(9, 10, 11, 11, 14, 17, 18, 9, 18, 22, 18, 11, 13, 20, 20, 28, 27)
    val expected: Array[Int] =
      Array(9, 9, 10, 11, 11, 11, 13, 14, 17, 18, 18, 18, 20, 20, 22, 27, 28)

    measure(sort(array))

    array shouldBe expected
  }

  it should "be success Long array" in {
    val array: Array[Long] =
      Array(7L, 8L, 8L, 5L, 15L, 16L, 12L, 18L, 15L, 15L, 11L, 13L, 22L, 19L, 29L, 26L, 28L)
    val expected: Array[Long] =
      Array(5L, 7L, 8L, 8L, 11L, 12L, 13L, 15L, 15L, 15L, 16L, 18L, 19L, 22L, 26L, 28L, 29L)

    measure(sort(array))

    array shouldBe expected
  }

  it should "be success Double array" in {
    val array: Array[Double] = Array(
      14.027289589238503, 1.8403829156090656, 16.463975618828332, 15.164986718129109,
      7.262623883501453, 8.947198410869117, 19.025868113234587, 20.27574015096203,
      23.40535972348279, 24.68220385130333, 23.53221090801606, 17.01676087289549, 20.05927996190266,
      17.174313487686252, 29.170211694613045, 16.78116966785659, 27.281651646031367
    )
    val expected: Array[Double] = Array(
      1.8403829156090656, 7.262623883501453, 8.947198410869117, 14.027289589238503,
      15.164986718129109, 16.463975618828332, 16.78116966785659, 17.01676087289549,
      17.174313487686252, 19.025868113234587, 20.05927996190266, 20.27574015096203,
      23.40535972348279, 23.53221090801606, 24.68220385130333, 27.281651646031367,
      29.170211694613045
    )

    measure(sort(array))

    array shouldBe expected
  }
}
