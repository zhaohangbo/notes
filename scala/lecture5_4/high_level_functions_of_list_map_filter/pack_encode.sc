package lecture5_4.high_level_functions_of_list_map_filter

object pack_encode {
  val data =List("a","a","a","a","a","b","b","a","a","c","b","b")
                                                  //> data  : List[String] = List(a, a, a, a, a, b, b, a, a, c, b, b)
	//pack data to =>  List(List(a, a, a, a, a), List(b, b), List(a, a)
	def pack[T](xs:List[T]):List[List[T]] =xs match{
		case Nil   => Nil
		case x::xs1=>
					val (fst,rest) = xs.span (list_i => list_i == x)
					fst::pack(rest)
	}                                         //> pack: [T](xs: List[T])List[List[T]]
	pack(data)                                //> res0: List[List[String]] = List(List(a, a, a, a, a), List(b, b), List(a, a),
                                                  //|  List(c), List(b, b))



	//encode data to => List((a,5), (b,2), (a,2), (c,1), (b,2))
	def encode[T](xs:List[T]):List[(T,Int)]   =  {
				pack(xs).map(list => (list.head, list.length))
	}                                         //> encode: [T](xs: List[T])List[(T, Int)]
	encode(data)                              //> res1: List[(String, Int)] = List((a,5), (b,2), (a,2), (c,1), (b,2))
}