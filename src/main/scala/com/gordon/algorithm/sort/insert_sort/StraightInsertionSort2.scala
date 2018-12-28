package com.gordon.algorithm.sort.insert_sort

import com.gordon.algorithm.sort.Sort

import scala.util.control.Breaks._

/**
  * 直接插入排序
  * 最差时间复杂度是O(n2)，但是在数据近乎有序的情况下，是O(n)
  */
class StraightInsertionSort2 extends Sort {

  override def sort(arr: Array[Int]): Unit = {
    for (i <- 1 until arr.length) {
      // 每经过一趟内层for循环，就能确定位置i(含)之前的元素是有序的
      val e = arr(i)
      var j = i
      // 寻找arr(i)合适的插入位置，这种方法优势是减少交换次数的指令数
      while (j > 0 && arr(j - 1) > e) {
        arr(j) = arr(j - 1)
        j -= 1
      }
      arr(j) = e
    }
  }

  override def name: String = "直接插入排序2"

}
