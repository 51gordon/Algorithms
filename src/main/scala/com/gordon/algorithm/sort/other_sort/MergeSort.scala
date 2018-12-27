package com.gordon.algorithm.sort.other_sort

import com.gordon.algorithm.sort.Sort

/**
 * 归并排序
 */
class MergeSort extends Sort {
  override def name: String = "两路归并排序"

  override def sort(arr: Array[Int]): Unit = {
    sort(arr, 0, arr.length - 1)
  }

  private def sort(arr: Array[Int], low: Int, high: Int): Unit = {
    val mid = (low + high) / 2
    if (low < high) {
      sort(arr, low, mid)
      sort(arr, mid + 1, high)
      merge(arr, low, mid, high)
    }
  }

  private def merge(arr: Array[Int], low: Int, mid: Int, high: Int): Unit = {
    val tmpArr = new Array[Int](high - low + 1)
    var i = low
    var j = mid + 1
    var k = 0
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
