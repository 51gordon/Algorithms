package com.gordon.algorithm.sort

import com.gordon.algorithm.sort.utils.SortUtils

import scala.util.Random

trait AbstractSortTest {

  val arr: Array[Int] = Array(8, 6, 2, 3, 1, 5, 4, 7)

  def showArr(arr: Array[Int]): Unit = println(arr.mkString(","))

  /**
    * 随机产生一个数组
    *
    * @param num 数组大小
    * @return
    */
  def generateRandomArray(num: Int = 10000): Array[Int] = {
    generateRandomNearlyOrderedArray(num / 2, num)
  }

  /**
    * 随机产生一个近乎有序的有序数组
    *
    * @param swapTimes 随机交换次数
    * @param num       数组大小
    * @return
    */
  def generateRandomNearlyOrderedArray(num: Int = 10000, swapTimes: Int = 100): Array[Int] = {
    val arr = Range(0, num).toArray
    val random = new Random()
    for (_ <- 0 until swapTimes) {
      val x = random.nextInt(num)
      val y = random.nextInt(num)
      SortUtils.swap(arr, x, y)
    }
    arr
  }

  def compareSort(arr: Array[Int], sorters: Sort*): Unit = {
    //    println(s"arr: ${arr.mkString(",")}")
    val result = sorters.map { sorter =>
      val _arr = new Array[Int](arr.length)
      Array.copy(arr, 0, _arr, 0, _arr.length)
      //      println(s"_arr before sort: ${_arr.mkString(",")}")
      val starTime = System.nanoTime()
      sorter.sort(_arr)
      //      println(s"_arr after  sort: ${_arr.mkString(",")}")
      (sorter, (System.nanoTime() - starTime) / math.pow(10, 9))
    }
    val maxNameLen = result.map(_._1.name.length).max
    result.foreach {
      case (sorter, cost) =>
        val name = String.format("%1$-" + maxNameLen + "s", sorter.name)
        println(name + ": " + cost.formatted("%.5f") + "s")
    }
  }

}
