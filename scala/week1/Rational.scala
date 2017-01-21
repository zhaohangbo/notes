package week1

class Rational(x:Int , y:Int){
	require(y>0,"the denominator must be none_zero")

	//Constructor
	def this(x:Int) = this(x,1)

	def gcd(a:Int,b:Int):Int=if(b==0)  a else gcd(b,a%b)

	def c =gcd(x,y)
	def numerator   = x/c
	def denominator = y/c

	def less(that:Rational):Boolean = numerator*that.denominator < denominator*that.numerator
	
	def max (that:Rational):Rational =if(this.less(that)) that else this

	def add (that:Rational):Rational =new Rational(this.numerator*that.denominator + that.numerator*this.denominator,this.denominator*that.denominator)
	def neg:Rational=new Rational(-numerator,denominator)
	def sub (that:Rational):Rational =this.add(that.neg)
	
  override def toString = numerator + "/" + denominator
}