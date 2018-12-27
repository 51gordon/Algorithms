package com.gordon.algorithm.sort.other_sort

import com.gordon.algorithm.sort.AbstractSortTest
import org.scalatest.FunSuite

/**
 * Author: Cheng Guodong
 * Date: 2018/12/27 17:11
 */
class MergeSortTest extends FunSuite with AbstractSortTest{

  test("testSort") {
    showArr(arr)
    new MergeSort().sort(arr)
    showArr(arr)
  }

}
