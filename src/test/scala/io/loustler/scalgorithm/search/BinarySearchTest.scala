package io.loustler.scalgorithm.search

import io.loustler.scalgorithm.BaseTest

/**
  * @author loustler
  * @since 01/03/2019
  */
class BinarySearchTest extends BaseTest {
  "BinarySearch" should "success" in {
    val array:    Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val target:   Int        = 7
    val expected: Int        = 6

    measure(BinarySearch.search(array, target)) shouldBe expected
  }
}
