package com.gordon.algorithm.sort.other_sort

import com.gordon.algorithm.sort.AbstractSortTest
import org.scalatest.FunSuite

class TwoWayMergeSort3Test extends FunSuite with AbstractSortTest {

  test("testSort") {
    val arr = Array(5, 1, 3, 2, 8, 6, 4, 7)
    simpleSortTest(new TwoWayMergeSort3(), arr)
  }

  test("compare TwoWayMergeSort and TwoWayMergeSort3") {
    val arr: Array[Int] = generateRandomArray()
    compareSort(arr,
      new TwoWayMergeSort(),
      new TwoWayMergeSort3()
    )
  }

}
