package com.gordon.algorithm.sort.swap_sort

import com.gordon.algorithm.sort.AbstractSortTest
import org.scalatest.FunSuite

class TwoWayQuickSort2Test extends FunSuite with AbstractSortTest {

  test("testSort") {
    val arr = Array(4, 7, 3, 2, 8, 6, 5, 1)
    simpleSortTest(new TwoWayQuickSort2(), arr)
  }

}
