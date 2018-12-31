package com.gordon.algorithm.sort.swap_sort

import com.gordon.algorithm.sort.AbstractSortTest
import com.gordon.algorithm.sort.other_sort.TwoWayMergeSort
import org.scalatest.FunSuite

class TwoWayQuickSortTest extends FunSuite with AbstractSortTest {

  test("testSort") {
    val arr = Array(4, 7, 3, 2, 8, 6, 5, 1)
    showArr(arr)
    val sorter = new TwoWayQuickSort()
    sorter.sort(arr)
    showArr(arr)
  }

  test("compare TwoWayMergeSort and TwoWayQuickSort") {
    val arr: Array[Int] = generateRandomArray(5000000)
    compareSort(arr,
      new TwoWayMergeSort(),
      new TwoWayQuickSort()
    )
  }

}
