package com.gordon.algorithm.sort.select_sort

import com.gordon.algorithm.sort.Sort

/**
  * 简单选择排序
  */
class SimpleSelectionSort extends Sort {
  override def sort(arr: Array[Int]): Unit = {
    for (i <- arr.indices) {
      var minIndex = i
      // 一趟for循环后，就可以知道最小的元素的位置，和当前元素交换之
      // 这样前n个就是有序的了
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
