package lecture5_5.reduction_of_list

object foldRight_foldLeft {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  def concat[T](xs:List[T],ys:List[T]):List[T] ={
 // 			(xs foldLeft ys)(_::_)//Error, value :: is not a member of type parameter T
   			(xs foldRight ys)(_::_)
  }                                               //> concat: [T](xs: List[T], ys: List[T])List[T]
}