package com.gordon.algorithm.dp

/**
  * 斐波那契数列
  */
object Fib {

  private var num = 0
  private var memo: Array[Long] = _

  // 记忆化搜索
  private def fib(n: Int): Long = {
    num += 1
    if (n < 2) n else {
      if (memo(n) == -1L) {
        memo(n) = fib(n - 1) + fib(n - 2)
      }
      memo(n)
    }
  }

  def main(args: Array[String]): Unit = {
    val n = 1000
    memo = Array.fill(n + 1)(-1)
    val startTime = System.nanoTime()
    val res = fib(n)
    val endTime = System.nanoTime()
    println(s"fib($n) = $res")
    println(s"num: $num")
    val cost = ((endTime - startTime) / math.pow(10, 9)).formatted("%.9f")
    //    val cost = (endTime - startTime) / math.pow(10, 9)
    println(s"time: $cost s")

  }
}
