package com.gordon.algorithm.sort.select_sort

import com.gordon.algorithm.sort.AbstractSortTest
import org.scalatest.FunSuite

class SimpleSelectionSortTest extends FunSuite with AbstractSortTest {

  test("testSort") {
    simpleSortTest(new SimpleSelectionSort())
  }

}
