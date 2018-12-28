package com.gordon.algorithm.sort.swap_sort

import com.gordon.algorithm.sort.AbstractSortTest
import org.scalatest.FunSuite

class BubbleSortTest extends FunSuite with AbstractSortTest {

  test("testSort") {
    showArr(arr)
    new BubbleSort().sort(arr)
    showArr(arr)
  }

}
