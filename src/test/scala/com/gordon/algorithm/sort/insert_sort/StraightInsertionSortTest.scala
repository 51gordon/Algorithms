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

  test("compare StraightInsertion and SimpleSelection") {
    val arr: Array[Int] = generateRandomArray()
    compareSort(arr,
      new StraightInsertionSort(),
      new StraightInsertionSort2(),
      new SimpleSelectionSort()
    )
  }

  test("compare StraightInsertion and SimpleSelection with nearly ordered array") {
    val arr: Array[Int] = generateRandomNearlyOrderedArray(10)
    compareSort(arr,
      new StraightInsertionSort(),
      new StraightInsertionSort2(),
      new SimpleSelectionSort()
    )
  }

}
