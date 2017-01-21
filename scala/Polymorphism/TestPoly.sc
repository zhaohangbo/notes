package Polymorphism


object TestPoly {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def Singleton[T](elem: T)=new Cons[T](elem,new Nil[T])
                                                  //> Singleton: [T](elem: T)Polymorphism.Cons[T]
                                                  
  Singleton(1)                                    //> res0: Polymorphism.Cons[Int] = Polymorphism.Cons@8170146
  Singleton(true)                                 //> res1: Polymorphism.Cons[Boolean] = Polymorphism.Cons@1e549ed0


	def nth[T](n:Int,list:List[T]):T={
			if (list.isEmpty) throw new IndexOutOfBoundsException
			else if (n==0)
			list.head
			else
			nth(n-1,list.tail)
	}                                         //> nth: [T](n: Int, list: Polymorphism.List[T])T


	val list =new Cons(1,new Cons(2,new Cons(3,new Cons(4,new Nil))))
                                                  //> list  : Polymorphism.Cons[Int] = Polymorphism.Cons@4586793e
	nth(2,list)                               //> res2: Int = 3
	
	nth(-1,list)                              //> java.lang.IndexOutOfBoundsException
                                                  //| 	at Polymorphism.TestPoly$$anonfun$main$1.nth$1(Polymorphism.TestPoly.sca
                                                  //| la:13)
                                                  //| 	at Polymorphism.TestPoly$$anonfun$main$1.apply$mcV$sp(Polymorphism.TestP
                                                  //| oly.scala:24)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at Polymorphism.TestPoly$.main(Polymorphism.TestPoly.scala:4)
                                                  //| 	at Polymorphism.TestPoly.main(Polymorphism.TestPoly.scala)

}