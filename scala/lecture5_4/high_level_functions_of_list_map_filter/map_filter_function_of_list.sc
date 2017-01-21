package lecture5_4.map_function_of_list



object map_function_of_list {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  //Two ways to implement squareList
  //1.partern match
  //2.map function of List
  
  def squareList(xs:List[Int]):List[Int] = xs match{
  	case Nil => Nil
  	case y::ys => y*y :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]
  def squareList_map(xs:List[Int]):List[Int] = {
  	xs.map { x => x*x }
  }                                               //> squareList_map: (xs: List[Int])List[Int]
 
 
 
 //Two ways to implement selectPosElems
 //1.partern match
 //2.filter
 
 def selectPosElems(xs:List[Int]) :List[Int] = xs match {
 		case Nil  => xs
 		case y::ys => if(y>0) y::selectPosElems(ys)
 								 else selectPosElems(ys)
 }                                                //> selectPosElems: (xs: List[Int])List[Int]
 
 def selectPosElems_fileter(xs:List[Int]):List[Int]=
    xs.filter(x => x > 0)                         //> selectPosElems_fileter: (xs: List[Int])List[Int]
    
    
    
  val list1 = List(12,3,2,31,-32,-44)             //> list1  : List[Int] = List(12, 3, 2, 31, -32, -44)
  selectPosElems_fileter(list1)                   //> res0: List[Int] = List(12, 3, 2, 31)
  
  
  val nums  = List(1,-9,4,-1,-3,7,6,5)            //> nums  : List[Int] = List(1, -9, 4, -1, -3, 7, 6, 5)
  val fruits= List("apple","pineapple","banana")  //> fruits  : List[String] = List(apple, pineapple, banana)
 	
 	nums.filter(	 x => x>0 )               //> res1: List[Int] = List(1, 4, 7, 6, 5)
  nums.filterNot(x => x>0)                        //> res2: List[Int] = List(-9, -1, -3)
	nums.partition(x => x>0)                  //> res3: (List[Int], List[Int]) = (List(1, 4, 7, 6, 5),List(-9, -1, -3))
	
	//stop when x<=0
	nums.takeWhile(x => x>0)                  //> res4: List[Int] = List(1)
	//drop the result of takewhile, remain the rest
	nums.dropWhile(x => x>0)                  //> res5: List[Int] = List(-9, 4, -1, -3, 7, 6, 5)
	//combine the takewhile and dropWhile
	nums.span(x => x>0)                       //> res6: (List[Int], List[Int]) = (List(1),List(-9, 4, -1, -3, 7, 6, 5))
	
	
	
	val data =List("a","a","a","a","a","b","b","a","a","c","b","b")
                                                  //> data  : List[String] = List(a, a, a, a, a, b, b, a, a, c, b, b)
	//pack data to =>  List(List(a, a, a, a, a), List(b, b), List(a, a)
	def pack[T](xs:List[T]):List[List[T]] =xs match{
		case Nil   => Nil
		case x::xs1=>
					val (fst,rest) = xs.span (list_i => list_i == x)
					fst::pack(rest)
	}                                         //> pack: [T](xs: List[T])List[List[T]]
	pack(data)                                //> res7: List[List[String]] = List(List(a, a, a, a, a), List(b, b), List(a, a)
                                                  //| , List(c), List(b, b))



	//encode data to => List((a,5), (b,2), (a,2), (c,1), (b,2))
	def encode[T](xs:List[T]):List[(T,Int)]   =  {
				pack(xs).map{list => (list.head, list.length)}
	}                                         //> encode: [T](xs: List[T])List[(T, Int)]
	encode(data)                              //> res8: List[(String, Int)] = List((a,5), (b,2), (a,2), (c,1), (b,2))
 }