package com.gordon.algorithm.dp

object IntegerBreak2 {
  private var memo: Array[Long] = _

  /** 将n进行分割（至少分割两部分），可以获得最大乘积 */
  private def breakInteger(n: Int): Long = {
    if (n == 1) 1
    else {
      if (memo(n) != -1) {
        memo(n)
      } else {
        var res = -1L
        for (i <- 1 until n) {
          res = math.max(i * (n - i), math.max(res, i * breakInteger(n - i)))
        }
        memo(n) = res
        res
      }
    }
  }

  def integerBreak(n: Int): Long = {
    assert(n >= 2)
    // memo(i)表示将数字i分割（至少分割成两部分）后得到的最大乘积
    memo(1) = 1
    for (i <- 2 to n) {
      // 求解memo(i)
      for (j <- 1 until i) {
        // j + (i - j)
        memo(i) = math.max(memo(i), math.max(j * (i - j), j * memo(i - j)))
      }
    }
    memo(n)
  }

  def main(args: Array[String]): Unit = {
    val n = 100
    memo = Array.fill(n + 1)(-1)
    val startTime = System.nanoTime()
    val res = integerBreak(n)
    val endTime = System.nanoTime()
    println(s"integerBreak($n) = $res")
    //    println(s"num: $num")
    val cost = ((endTime - startTime) / math.pow(10, 9)).formatted("%.9f")
    //    val cost = (endTime - startTime) / math.pow(10, 9)
    println(s"time: $cost s")
  }
}
