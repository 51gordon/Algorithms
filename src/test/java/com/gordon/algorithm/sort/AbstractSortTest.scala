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
    val t0 = System.currentTimeMillis()
    sorter1.sort(arr)
    val t1 = System.currentTimeMillis()
    sorter2.sort(_arr)
    val t2 = System.currentTimeMillis()

    println(sorter1.name + ": " + (t1 - t0) / 1000.0 + "s")
    println(sorter2.name + ": " + (t2 - t1) / 1000.0 + "s")

  }

}
