package com.gordon.algorithm.sort.insert_sort

import com.gordon.algorithm.sort.Sort
import com.gordon.algorithm.sort.utils.SortUtils

import util.control.Breaks._

/**
  * 直接插入排序
  * 平均时间复杂度是O(n2)
  */
class StraightInsertionSort extends Sort {

  override def sort(arr: Array[Int]): Unit = {
    for (i <- 1 until arr.length) {
      // 每经过一趟内层for循环，就能确定位置i(含)之前的元素是有序的
      breakable(
        // 寻找arr(i)合适的插入位置
        for (j <- Range(i, 0, -1)) {
          if (arr(j) < arr(j - 1)) SortUtils.swap(arr, j, j - 1) else break
        }
      )
    }
  }

  override def name: String = "直接插入排序"

}
