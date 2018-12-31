package com.gordon.algorithm.sort.other_sort

import com.gordon.algorithm.sort.Sort

/**
  * 归并排序(不使用递归)
  * 时间复杂度: O(nlgn)
  * 空间复杂度: O(n)
  */
class TwoWayMergeSort3 extends Sort {
  override def name: String = "两路归并排序(不使用递归)"

  override def sort(arr: Array[Int]): Unit = {
    sort(arr, 0, arr.length - 1)
  }

  // 递归使用归并排序，对arr[low...high]的范围进行排序
  private def sort(arr: Array[Int], low: Int, high: Int): Unit = {
    var sz = 1
    while (sz <= arr.length) {
      var i = 0
      while (i + sz < arr.length) {
        merge(arr, i, i + sz - 1, math.min(i + sz * 2 - 1, arr.length - 1))
        i += sz * 2
      }
      sz += sz
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
