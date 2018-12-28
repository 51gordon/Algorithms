package com.gordon.algorithm.sort.swap_sort

import com.gordon.algorithm.sort.Sort
import com.gordon.algorithm.sort.utils.SortUtils

/**
  * 冒泡排序
  * 时间复杂度：O(n2)
  * 空间复杂度：O(1)
  */
class BubbleSort extends Sort {
  override def name: String = "冒泡排序"

  override def sort(arr: Array[Int]): Unit = {
    for (i <- arr.indices) {
      // 将第i个元素依次和后面的比较，一趟内层循环后最小的元素就挪到左边了
      for (j <- i + 1 until arr.length) {
        if (arr(i) > arr(j)) {
          SortUtils.swap(arr, i, j)
        }
      }
    }
  }
}
