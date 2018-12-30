package com.gordon.algorithm.sort.other_sort

import com.gordon.algorithm.sort.Sort

/**
  * 归并排序(相比TwoWayMergeSort没有什么性能优化，是视频c++的移植版)
  * 时间复杂度: O(nlgn)
  * 空间复杂度: O(n)
  */
class TwoWayMergeSort2 extends Sort {
  override def name: String = "两路归并排序2"

  override def sort(arr: Array[Int]): Unit = {
    sort(arr, 0, arr.length - 1)
  }

  // 递归使用归并排序，对arr[low...high]的范围进行排序
  private def sort(arr: Array[Int], low: Int, high: Int): Unit = {
    val mid = low + (high - low) / 2
    //    val mid = (low + high) / 2 // 不建议使用这种写法，因为可能出现整型溢出问题
    if (low < high) {
      sort(arr, low, mid) // 左边归并排序，使得左子序列有序
      sort(arr, mid + 1, high) // 右边归并排序，使得右子序列有序
      merge(arr, low, mid, high) // 合并左右两个子序列
    }
  }

  private def merge(arr: Array[Int], low: Int, mid: Int, high: Int): Unit = {
    val tmpArr = new Array[Int](high - low + 1)
    for (i <- low to high) {
      tmpArr(i - low) = arr(i)
    }
    var i = low // 左序列指针
    var j = mid + 1 // 右序列指针
    var k = low // 临时数组 tmpArr 指针
    while (k <= high) {
      if (i > mid) {
        // 左序列已操作完毕
        arr(k) = tmpArr(j - low)
        j += 1
      } else if (j > high) {
        // 右序列已操作完毕
        arr(k) = tmpArr(i - low)
        i += 1
      } else if (tmpArr(i - low) < tmpArr(j - low)) {
        // 左序列 > 右序列
        arr(k) = tmpArr(i - low)
        i += 1
      } else {
        arr(k) = tmpArr(j - low)
        j += 1
      }
      k += 1
    }
  }
}
