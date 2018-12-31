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
    arr.indices.exists { index =>
      !(index < arr.length - 1 && arr(index) > arr(index + 1))
    }
  }
}
