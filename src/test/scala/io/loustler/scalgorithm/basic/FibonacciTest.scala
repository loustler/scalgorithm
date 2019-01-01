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

package io.loustler.scalgorithm.basic

import io.loustler.scalgorithm.BaseTest
import io.loustler.scalgorithm.basic.Fibonacci._

/**
  * @author loustler
  * @since 01/01/2019
  */
class FibonacciTest extends BaseTest {
  "Fibonacci" should "be success by recursive" in {
    val fibonacciNumber: Int = 5
    val fifthFibonacci:  Int = 5

    val secondFibonacciNumber: Int = 9
    val ninthFibonacci:        Int = 34

    val thirdFibonacciNumber: Int = 17
    val seventeenthFibonacci: Int = 1597

    measure(recursive(fibonacciNumber)) shouldBe fifthFibonacci
    measure(recursive(secondFibonacciNumber)) shouldBe ninthFibonacci
    measure(recursive(thirdFibonacciNumber)) shouldBe seventeenthFibonacci
  }

  it should "be success by inner recursive" in {
    val firstFibonacciNumber: Int = 6
    val sixthFibonacci:       Int = 8

    val secondFibonacciNumber: Int = 13
    val thirteenthFibonacci:   Int = 233

    val thirdFibonacciNumber: Int = 23
    val twentyOneFibonacci:   Int = 28657

    measure(inner(firstFibonacciNumber)) shouldBe sixthFibonacci
    measure(inner(secondFibonacciNumber)) shouldBe thirteenthFibonacci
    measure(inner(thirdFibonacciNumber)) shouldBe twentyOneFibonacci
  }

  it should "more effective recursion" in {
    val fibonacciNumber: Int = 5
    val fifthFibonacci:  Int = 5

    val secondFibonacciNumber: Int = 9
    val ninthFibonacci:        Int = 34

    val thirdFibonacciNumber: Int = 17
    val seventeenthFibonacci: Int = 1597

    measure(effectiveRecursive(fibonacciNumber)) shouldBe fifthFibonacci
    measure(effectiveRecursive(secondFibonacciNumber)) shouldBe ninthFibonacci
    measure(effectiveRecursive(thirdFibonacciNumber)) shouldBe seventeenthFibonacci
  }
}
