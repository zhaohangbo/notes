package week1

object Session {
  1 + 2                                           //> res0: Int(3) = 3
  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double
  abs(-2)                                         //> res1: Double = 2.0

  def sqrt(x: Double) = {
    def iterSqrt(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else iterSqrt(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) < 0.001 * x

    def improve(guess: Double) =
      (guess + x / guess) / 2
    iterSqrt(1)

  }                                               //> sqrt: (x: Double)Double

  //  iterSqrt(1, 2)
  //def sqrt(x: Double) = iterSqrt(1.0, x)

  sqrt(2)                                         //> res2: Double = 1.4142156862745097
  sqrt(4)                                         //> res3: Double = 2.000609756097561
  sqrt(1e-6)                                      //> res4: Double = 0.0010000001533016628
  sqrt(1e6)                                       //> res5: Double = 1000.0001533016629

}