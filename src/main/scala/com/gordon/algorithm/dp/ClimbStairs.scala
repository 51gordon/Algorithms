package com.gordon.algorithm.dp

object ClimbStairs {
  private var memo: Array[Int] = _

  private def calcWays(n: Int): Int = {
    if (n == 1) 1
    else if (n == 2) 2
    else {
      if (memo(n - 1) == -1) {
        memo(n - 1) = calcWays(n - 1) + calcWays(n - 2)
      }
      memo(n - 1)
    }
  }

  def climbStairs(n: Int): Int = {
    calcWays(n)
  }

  def main(args: Array[String]): Unit = {
    val n = 45
    memo = Array.fill(n)(-1)
    val startTime = System.nanoTime()
    val res = climbStairs(n)
    val endTime = System.nanoTime()
    println(s"climbStairs($n) = $res")
    //    println(s"num: $num")
    val cost = ((endTime - startTime) / math.pow(10, 9)).formatted("%.9f")
    //    val cost = (endTime - startTime) / math.pow(10, 9)
    println(s"time: $cost s")
  }
}
