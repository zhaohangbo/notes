package week1

object exercise_currying {

	def  product(f:Int=>Int)(a:Int,b:Int):Int={
			if(a>b) 1
			else f(a)*product(f)(a+1,b)
								
	}                                         //> product: (f: Int => Int)(a: Int, b: Int)Int
 
	product (x=>x*x)(3,4)                     //> res0: Int = 144
 
 
 
  def factorial(x:Int):Int =  x                   //> factorial: (x: Int)Int
 
  product (factorial)(1,3)                        //> res1: Int = 6
  
  
 
 
  
	def mapReduce(f:Int=>Int , combine:(Int,Int)=>Int , zero :Int)(a:Int,b:Int):Int={
		 	if(a>b) zero
		 	else combine(f(a),mapReduce(f, combine, zero)(a+1, b))
	}                                         //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
	def product2(f:Int=>Int)(a:Int,b:Int):Int =mapReduce(f, (a,b)=>a*b, 1)(a, b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
 
 
 
 
 
 
 
  product2(x=>x*x)(3,4)                           //> res2: Int = 144
  
}