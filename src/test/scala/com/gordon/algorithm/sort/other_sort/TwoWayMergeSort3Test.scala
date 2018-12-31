package com.gordon.algorithm.sort.other_sort

import com.gordon.algorithm.sort.AbstractSortTest
import org.scalatest.FunSuite

class TwoWayMergeSort3Test extends FunSuite with AbstractSortTest {

  test("testSort") {
    val arr = Array(5, 1, 3, 2, 8, 6, 4, 7)
    showArr(arr)
    val sorter = new TwoWayMergeSort3()
    sorter.sort(arr)
    showArr(arr)
  }

  test("compare TwoWayMergeSort2 and TwoWayMergeSort3") {
    val arr: Array[Int] = generateRandomArray()
    compareSort(arr,
      new TwoWayMergeSort2(),
      new TwoWayMergeSort3()
    )
  }

}
