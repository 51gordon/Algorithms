package com.gordon.algorithm.sort

/**
  * 排序接口
  */
trait Sort {

  def name: String

  def sort(arr: Array[Int]): Unit

  protected def swap(arr: Array[Int], x: Int, y: Int) {
    if (x != y) {
      val tmp = arr(x)
      arr(x) = arr(y)
      arr(y) = tmp
    }
  }
}
