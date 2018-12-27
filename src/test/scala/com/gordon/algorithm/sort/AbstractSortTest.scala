package com.gordon.algorithm.sort

import scala.util.Random

trait AbstractSortTest {

  val arr: Array[Int] = Array(8, 6, 2, 3, 1, 5, 7, 4)

  def showArr(arr: Array[Int]): Unit = println(arr.mkString(","))

  def randomArray(num: Int = 10000): Array[Int] = {
    val random = new Random()
    Range(0, num).map(_ => random.nextInt(num)).toArray
  }

  def compareSort(arr: Array[Int], sorter1: Sort, sorter2: Sort): Unit = {
    val _arr = new Array[Int](arr.length)
    Array.copy(arr, 0, _arr, 0, _arr.length)
    val t0 = System.nanoTime()
    sorter1.sort(arr)
    val t1 = System.nanoTime()
    sorter2.sort(_arr)
    val t2 = System.nanoTime()

    val cost1 = (t1 - t0) / math.pow(10, 9)
    val cost2 = (t2 - t1) / math.pow(10, 9)
    val times = if (cost1 >= cost2) cost1 / cost2 else cost2 / cost1

    println(sorter1.name + ": " + cost1.formatted("%.5f") + "s")
    println(sorter2.name + ": " + cost2.formatted("%.5f") + "s")
    println("耗时倍数: " + times.formatted("%.3f"))

  }

}
