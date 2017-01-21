package week1

object Intset_class_hierarchies {
	val t1 =new NotEmpty(3,new Empty,new Empty)
                                                  //> t1  : week1.NotEmpty = {.3.}
  val t2 =t1 incl 4                               //> t2  : week1.IntSet = {.3{.4.}}
}


abstract class IntSet{
	def incl(x:Int):  IntSet
	def contains(x:Int): Boolean
	def union(other:IntSet): IntSet
}

class Empty extends IntSet{
	def incl(x:Int):IntSet =new NotEmpty(x,new Empty,new Empty)
	def contains(x:Int):Boolean=false
	override def toString = "."
	def union(other:IntSet):IntSet=other
}


class NotEmpty(elem:Int,left:IntSet,right:IntSet) extends IntSet{
	def contains(x:Int):Boolean=
		if(x<elem) left.contains(x)
		else if(x>elem) right.contains(x)
		else true
	
	def incl(x:Int):IntSet=
		if(x<elem) new NotEmpty(elem,left incl x,right)
		else if(x>elem) new NotEmpty(elem,left ,right incl x)
		else this

	def union(other:IntSet):IntSet=
		((left union right) union other) incl elem
			
	override def toString="{"+left + elem + right+"}"

}