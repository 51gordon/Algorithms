package com.gordon.algorithm.sort.insert_sort

import com.gordon.algorithm.sort.AbstractSortTest
import com.gordon.algorithm.sort.select_sort.SimpleSelectionSort
import org.scalatest.FunSuite

class StraightInsertionSortTest extends FunSuite with AbstractSortTest {

  test("testSort") {
    showArr(arr)
    new StraightInsertionSort().sort(arr)
    showArr(arr)
  }

  test("compare StraightInsertionSort and SimpleSelectionSort") {
    val arr: Array[Int] = randomArray()
    compareSort(arr, new StraightInsertionSort(), new SimpleSelectionSort())
  }

}
