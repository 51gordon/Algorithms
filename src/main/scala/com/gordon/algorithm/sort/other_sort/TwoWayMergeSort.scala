package com.gordon.algorithm.sort.other_sort

import com.gordon.algorithm.sort.Sort

/**
  * 归并排序
  * 时间复杂度: O(nlgn)
  * 空间复杂度: O(n)
  */
class TwoWayMergeSort extends Sort {
  override def name: String = "两路归并排序"

  override def sort(arr: Array[Int]): Unit = {
    val tmpArr = new Array[Int](arr.length)
    sort(arr, 0, arr.length - 1, tmpArr)
  }

  // 递归使用归并排序，对arr[low...high]的范围进行排序
  private def sort(arr: Array[Int], low: Int, high: Int, tmpArr: Array[Int]): Unit = {
    val mid = low + (high - low) / 2
    //    val mid = (low + high) / 2 // 不建议使用这种写法，因为可能出现整型溢出问题
    if (low < high) {
      sort(arr, low, mid, tmpArr) // 左边归并排序，使得左子序列有序
      sort(arr, mid + 1, high, tmpArr) // 右边归并排序，使得右子序列有序
      // 如果左右两边整体已经完全有序，那么不需要归并了
      if (arr(mid) > arr(mid + 1)) {
        merge(arr, low, mid, high, tmpArr) // 合并左右两个子序列
      }
    }
  }

  private def merge(arr: Array[Int], low: Int, mid: Int, high: Int, tmpArr: Array[Int]): Unit = {
    var i = low // 左序列指针
    var j = mid + 1 // 右序列指针
    var k = 0 // 临时数组 tmpArr 指针
    // 左右两部分都已经各自有序，合并之
    while (i <= mid && j <= high) {
      if (arr(i) <= arr(j)) {
        tmpArr(k) = arr(i)
        i += 1
      } else {
        tmpArr(k) = arr(j)
        j += 1
      }
      k += 1
    }

    // 把左边剩余的数移入数组
    while (i <= mid) {
      tmpArr(k) = arr(i)
      i += 1
      k += 1
    }

    // 把右边边剩余的数移入数组
    while (j <= high) {
      tmpArr(k) = arr(j)
      j += 1
      k += 1
    }

    // 把新数组中的数覆盖原数组中[low...high]部分
    for (x <- low to high) {
      arr(x) = tmpArr(x - low)
    }
  }
}
