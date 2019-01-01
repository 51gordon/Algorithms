package com.gordon.algorithm.dp

object ClimbStairs2 {

  private var memo: Array[Long] = _

  def climbStairs(n: Int): Long = {
    for (i <- 2 until n) {
      memo(i) = memo(i - 1) + memo(i - 2)
    }
    memo(n - 1)
  }

  def main(args: Array[String]): Unit = {
    val n = 450
    memo = Array.fill(n)(-1)
    memo(0) = 1L
    memo(1) = 2L
    val startTime = System.nanoTime()
    val res = climbStairs(n)
    val endTime = System.nanoTime()
    println(memo.mkString(","))
    println(s"climbStairs($n) = $res")
    val cost = ((endTime - startTime) / math.pow(10, 9)).formatted("%.9f")
    println(s"time: $cost s")
  }
}
