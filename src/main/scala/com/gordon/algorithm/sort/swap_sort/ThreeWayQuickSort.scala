package com.gordon.algorithm.sort.swap_sort

import com.gordon.algorithm.sort.Sort
import com.gordon.algorithm.sort.utils.SortUtils

import scala.util.Random

/**
  * 三路快速排序
  */
class ThreeWayQuickSort extends Sort {
  // TODO 该实现有问题，暂时没解决
  override def name: String = "三路快速排序"

  override def sort(arr: Array[Int]): Unit = {
    val random = new Random()
    quickSort(arr, 0, arr.length - 1, random)
  }

  private def quickSort(arr: Array[Int], low: Int, high: Int, random: Random): Unit = {
    if (low < high) {
      val (lt, gt) = partition(arr, low, high, random)
      quickSort(arr, low, lt - 1, random)
      quickSort(arr, gt + 1, high, random)
    }
  }

  private def partition(arr: Array[Int], low: Int, high: Int, random: Random): (Int, Int) = {
//    val v = arr(low + random.nextInt(high + 1 - low))
    val v = arr(low)
    var lt = low // arr[low+1...lt] < v
    var gt = high // arr[gt+1...high] > v
    var i = low + 1 // arr[lt+1...i) == v
    while (i < gt) {
      if (arr(i) < v) {
        SortUtils.swap(arr, i, lt + 1)
        lt += 1
        i += 1
      } else if (arr(i) > v) {
        SortUtils.swap(arr, i, gt - 1)
        gt -= 1
      } else { // arr(i) == v
        i += 1
      }
    }
    SortUtils.swap(arr, low, lt)
    (lt, gt)
  }
}
