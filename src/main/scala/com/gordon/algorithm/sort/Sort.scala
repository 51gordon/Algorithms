package com.gordon.algorithm.sort

/**
  * 排序接口
  */
trait Sort {

  def name: String

  def sort(arr: Array[Int]): Unit

}
