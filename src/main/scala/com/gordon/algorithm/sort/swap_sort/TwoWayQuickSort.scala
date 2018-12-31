package com.gordon.algorithm.sort.swap_sort

import com.gordon.algorithm.sort.Sort
import com.gordon.algorithm.sort.utils.SortUtils

import scala.util.Random

/**
  * 两路快速排序
  * 时间复杂度：O(nlgn)，在数据近乎有序的情况下，会退化为n2
  * 空间复杂度：O(1)
  */
class TwoWayQuickSort extends Sort {
  override def name: String = "两路快速排序"

  override def sort(arr: Array[Int]): Unit = {
    val random = new Random()
    quickSort(arr, 0, arr.length - 1, random)
  }

  private def quickSort(arr: Array[Int], low: Int, high: Int, random: Random): Unit = {
    if (low < high) {
      val p = partition(arr, low, high, random)
      quickSort(arr, low, p - 1, random)
      quickSort(arr, p + 1, high, random)
    }
  }

  private def partition(arr: Array[Int], low: Int, high: Int, random: Random): Int = {
    val v = arr(low + random.nextInt(high - low))
//    val v = arr(low) // 对于近乎有序的数组，这种方式取标定元素会导致分割后树退化为链表
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
