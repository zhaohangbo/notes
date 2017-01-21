package lecture5_2.pairs_tuples

import math.Ordering

object mergesort {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def msort[T](xs:List[T])(ord : Ordering[T]):List[T] = {
  			val n = xs.length/2
  			if(n==0) xs
  			else{
			  					def merge(xs:List[T],ys:List[T]):List[T] =(xs,ys) match {
			  					case (Nil,ys) => ys
			  					case (xs,Nil) => xs
			  					case (x::xs1,y::ys1) =>
			  						if(ord.lt(x,y))  	x::merge(xs1,ys)
			  						else  		y::merge(xs,ys1)
			  					}
				val (fst , snd) = xs splitAt(n)
				merge(msort(fst)(ord),msort(snd)(ord ))
  			}
				
  }                                               //> msort: [T](xs: List[T])(ord: scala.math.Ordering[T])List[T]
  
   
  val nums  = List(-9,4,-1,-3,7,6,5)              //> nums  : List[Int] = List(-9, 4, -1, -3, 7, 6, 5)
  val fruits= List("apple","pineapple","banana")  //> fruits  : List[String] = List(apple, pineapple, banana)
  msort(nums)(Ordering.Int)                       //> res0: List[Int] = List(-9, -3, -1, 4, 5, 6, 7)
  msort(fruits)(Ordering.String)                  //> res1: List[String] = List(apple, banana, pineapple)
}