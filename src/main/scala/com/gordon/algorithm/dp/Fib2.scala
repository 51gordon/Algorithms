package com.gordon.algorithm.dp

/**
  * 斐波那契数列
  */
class Fib2 {

  var num = 0

  private def fib(n: Int): Long = {
    num += 1
    if (n < 2) n else fib(n - 1) + fib(n - 2)
  }

}

object Fib2{
  def main(args: Array[String]): Unit = {
    for (i <- 0 to 40) {
      val fib = new Fib2()
      fib.fib(i)
      println(s"$i,${fib.num}")
    }
  }
}
