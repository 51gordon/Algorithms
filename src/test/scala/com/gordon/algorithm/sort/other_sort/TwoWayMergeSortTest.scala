package com.gordon.algorithm.sort.other_sort

import com.gordon.algorithm.sort.AbstractSortTest
import com.gordon.algorithm.sort.insert_sort.{StraightInsertionSort, StraightInsertionSort2}
import org.scalatest.FunSuite

/**
  * Author: Cheng Guodong
  * Date: 2018/12/27 17:11
  */
class TwoWayMergeSortTest extends FunSuite with AbstractSortTest {

  test("testSort") {
    showArr(arr)
    val sorter = new TwoWayMergeSort()
    sorter.sort(arr)
    showArr(arr)
  }

  test("compare InsertionSort and TwoWayMergeSort") {
    val arr: Array[Int] = randomArray(50000)
    compareSort(arr,
      new StraightInsertionSort(),
      new TwoWayMergeSort()
    )
  }

}
