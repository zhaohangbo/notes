package week1

object rationals {
  println("Welcome to the Scala worksheet")
	
	val x = new Rational(1,2)
	val y = new Rational(2,3)
	val z = new Rational(3,2)

	x.numerator
	x.denominator
	
	x.add(y)
	x.sub(y).sub(z)
	x.max(y)
	
	var zero_deno =new Rational(1,0)
	
}