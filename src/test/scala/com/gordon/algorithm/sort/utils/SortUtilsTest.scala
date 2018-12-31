package com.gordon.algorithm.sort.utils

import org.scalatest.FunSuite

class SortUtilsTest extends FunSuite {

  test("testIsSorted") {
    assert(SortUtils.isSorted(Array(1, 2, 3)))
    assert(!SortUtils.isSorted(Array(3, 2, 1)))
  }

}
