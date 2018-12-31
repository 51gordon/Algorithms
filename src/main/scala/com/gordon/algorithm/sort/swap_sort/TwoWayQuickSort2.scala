package com.gordon.algorithm.sort.swap_sort

import com.gordon.algorithm.sort.Sort
import com.gordon.algorithm.sort.utils.SortUtils

import scala.util.Random
import scala.util.control.Breaks._

/**
  * 两路快速排序，针对有大量重复元素进行优化，让等于标定值的元素基本上平分到两个子序列
  * 时间复杂度：O(nlgn)，在数据近乎有序的情况下，会退化为n2
  * 空间复杂度：O(1)
  */
class TwoWayQuickSort2 extends Sort {
  override def name: String = "两路快速排序2"

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
    SortUtils.swap(arr, low, low + random.nextInt(high - low + 1))
    val v = arr(low)
    // arr[low+1...i) <= v; arr(j...high] >= v
    var i = low + 1
    var j = high

    breakable {
      while (true) {
        while (i <= high && arr(i) < v) {
          i += 1
        }
        while (j >= low + 1 && arr(j) > v) {
          j -= 1
        }
        if (i > j) {
          break
        }
        SortUtils.swap(arr, i, j)
        i += 1
        j -= 1
      }
    }
    SortUtils.swap(arr, low, j)
    j
  }
}
