package com.gordon.algorithm.sort.swap_sort

import com.gordon.algorithm.sort.Sort
import com.gordon.algorithm.sort.utils.SortUtils

/**
  * 快速排序
  */
class TwoWayQuickSort extends Sort {
  override def name: String = "两路快速排序"

  override def sort(arr: Array[Int]): Unit = {
    quickSort(arr, 0, arr.length - 1)
  }

  private def quickSort(arr: Array[Int], low: Int, high: Int): Unit = {
    if (low < high) {
      val p = partition(arr, low, high)
      quickSort(arr, low, p - 1)
      quickSort(arr, p + 1, high)
    }
  }

  private def partition(arr: Array[Int], low: Int, high: Int): Int = {
    val v = arr(low)
    var j = low // j 是元素arr(low) 最应该所处的位置
    // arr[low+1,...j] < v; arr[j+1...high] > v
    for (i <- low + 1 to high) {
      if (arr(i) < v) {
        SortUtils.swap(arr, j + 1, i)
        j += 1
      }
    }
    SortUtils.swap(arr, low, j)
    j
  }
}
