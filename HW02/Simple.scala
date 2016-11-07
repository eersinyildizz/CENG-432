object Simple extends App {
	val array = Array(10,25,30)
	array.foreach(y=> if(y%2==0) println(y*2) else println(y*3))	
}