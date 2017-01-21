package lecture4_4.variance_optional

trait List[+T] {
   def isEmpty: Boolean
   def head: T
   def tail:List[T]
   def prepend[U>:T](ele:U) :List[U]= new Cons(ele,this)
}

trait cool[-T]{
  
}

class Cons[T](val head:T,val tail:List[T]) extends List[T]{
  def isEmpty =false
}

object Nil extends List[Nothing]{
  def isEmpty =true
  def head:Nothing=throw new NoSuchElementException("Nil.head")
  def tail:Nothing=throw new NoSuchElementException("Nil.tail")

}



//Lecture-4.1-Function as Object, eta expansion
object test{
  val x:List[String] = Nil  //  List[+T]
}

