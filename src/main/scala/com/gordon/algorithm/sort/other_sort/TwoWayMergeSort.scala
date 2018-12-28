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

  private def sort(arr: Array[Int], low: Int, high: Int, tmpArr: Array[Int]): Unit = {
    val mid = (low + high) / 2
    if (low < high) {
      sort(arr, low, mid, tmpArr) // 左边归并排序，使得左子序列有序
      sort(arr, mid + 1, high, tmpArr) // 右边归并排序，使得右子序列有序
      merge(arr, low, mid, high) // 合并左右两个子序列
    }
  }

  private def merge(arr: Array[Int], low: Int, mid: Int, high: Int): Unit = {
    val tmpArr = new Array[Int](high - low + 1)
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

    // 把新数组中的数覆盖原数组
    for (x <- tmpArr.indices) {
      arr(x + low) = tmpArr(x)
    }
  }
}
