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

  test("compare TwoWayMergeSort and TwoWayQuickSort with nearly ordered array") {
    val arr: Array[Int] = generateRandomNearlyOrderedArray(500000)
    compareSort(arr,
      new TwoWayMergeSort(),
      // 待排序数据集近乎有序时，快速排序会退化为O(n^2)级别
      new TwoWayQuickSort()
    )
  }

  test("compare TwoWayMergeSort and TwoWayQuickSort with many repeated element array") {
    val arr: Array[Int] = generateRandomArrayInRange(1000000, 0, 10)
    compareSort(arr,
      new TwoWayMergeSort(),
      // 待排序元素包含大量重复元素时，partition操作后，两个子序列会非常不平衡，导致退化为O(n^2)
      new TwoWayQuickSort()
    )
  }
}
