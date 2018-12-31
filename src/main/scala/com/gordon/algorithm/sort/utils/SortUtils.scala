package com.gordon.algorithm.sort.utils

object SortUtils {
  def swap(arr: Array[Int], x: Int, y: Int) {
    if (x != y) {
      val tmp = arr(x)
      arr(x) = arr(y)
      arr(y) = tmp
    }
  }

  def isSorted(arr: Array[Int]): Boolean = {
    !Range(0, arr.length - 1).exists { index =>
      arr(index) > arr(index + 1)
    }
  }
}
