package com.gordon.algorithm.sort

import com.gordon.algorithm.sort.utils.SortUtils

import scala.util.Random

trait AbstractSortTest {

  val arr: Array[Int] = Array(8, 6, 2, 3, 1, 5, 4, 7)

  def showArr(arr: Array[Int]): Unit = println(arr.mkString(","))

  /**
    * 随机产生一个数组
    * @param num 数组大小
    * @return
    */
  def generateRandomArray(num: Int = 10000): Array[Int] = {
    val random = new Random()
    Range(0, num).map(_ => random.nextInt(num)).toArray
  }

  /**
    * 随机产生一个近乎有序的有序数组
    * @param swapTimes 随机交换次数
    * @param num 数组大小
    * @return
    */
  def generateRandomNearlyOrderedArray(swapTimes: Int, num: Int = 10000): Array[Int] = {
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
    val result = sorters.map { sorter =>
      val _arr = new Array[Int](arr.length)
      Array.copy(arr, 0, _arr, 0, _arr.length)
      val starTime = System.nanoTime()
      sorter.sort(_arr)
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
