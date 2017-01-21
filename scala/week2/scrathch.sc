package week2

import week1.Rational

object scrathch {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
 // new Rational(1,2)
  new Rational(21,22)                             //> res0: week1.Rational = 21/22

	def err(msg : String) :String = throw new Error(msg)
                                                  //> err: (msg: String)String

//	err("err in Hangbo")

	val x= null                               //> x  : Null = null
	val y:String=null                         //> y  : String = null
	//val z:Int =null //null is imcompatible with subtype of anyVal

}