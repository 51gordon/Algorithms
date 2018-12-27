package com.gordon.algorithm.sort.other_sort

import com.gordon.algorithm.sort.Sort

/**
 * 归并排序
 */
class MergeSort extends Sort {
  override def name: String = "两路归并排序"

  override def sort(arr: Array[Int]): Unit = {
    sort(arr, 0, arr.length)
  }

  def sort(arr: Array[Int], low: Int, high: Int): Unit = {
    val mid = (low + high) / 2
  }
}
