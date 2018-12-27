package com.gordon.algorithm.sort.other_sort

import com.gordon.algorithm.sort.AbstractSortTest
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
    println(sorter.count)
    showArr(arr)
  }

}
