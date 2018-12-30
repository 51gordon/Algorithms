package com.gordon.algorithm.sort.other_sort

import com.gordon.algorithm.sort.AbstractSortTest
import com.gordon.algorithm.sort.insert_sort.StraightInsertionSort
import org.scalatest.FunSuite

/**
  * Author: Cheng Guodong
  * Date: 2018/12/27 17:11
  */
class TwoWayMergeSort2Test extends FunSuite with AbstractSortTest {

  test("testSort") {
    val arr = Array(5,1,3,2,8,6,4,7)
    showArr(arr)
    val sorter = new TwoWayMergeSort2()
    sorter.sort(arr)
    showArr(arr)
  }

  test("compare InsertionSort and TwoWayMergeSort2") {
    val arr: Array[Int] = generateRandomArray(50000)
    compareSort(arr,
      new StraightInsertionSort(),
      new TwoWayMergeSort2()
    )
  }

  test("compare TwoWayMergeSort and TwoWayMergeSort2") {
    val arr: Array[Int] = generateRandomArray(50000)
    compareSort(arr,
      new TwoWayMergeSort(),
      new TwoWayMergeSort2()
    )
  }

}
