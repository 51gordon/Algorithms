package com.gordon.algorithm.sort.select_sort

import com.gordon.algorithm.sort.Sort

/**
  * 简单选择排序
  */
class SimpleSelectionSort extends Sort {
  override def sort(arr: Array[Int]): Unit = {
    for (i <- arr.indices) {
      var minIndex = i
      for (j <- i + 1 until arr.length) {
        if (arr(j) < arr(minIndex)) {
          minIndex = j
        }
      }
      swap(arr, i, minIndex)
    }
  }

  override def name: String = "简单选择排序"
}
