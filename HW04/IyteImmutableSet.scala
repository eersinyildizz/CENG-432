class IyteImmutableSet {
  var arraySize = 20
  var list = new Array[Int](arraySize)
  var numberOfElement = 0
  
  def add(element: Int): Unit = {
  if (numberOfElement == arraySize)
      println("Can not add more elements.")

    if (!contains(element)) {

      if (numberOfElement <= arraySize) {

        list(numberOfElement) = element

        numberOfElement += 1

      }

    }
  }
  def contains(element: Int): Boolean = {
    var exist: Boolean = false
    var lowerBound = 0;
    var upperBound = numberOfElement - 1;
    var curIn = 0

   while (lowerBound <= upperBound) {

      curIn = (upperBound + lowerBound) / 2;

      if (list(curIn) > element) {
        upperBound = curIn - 1;
      } else if (list(curIn) < element) {
        lowerBound = curIn + 1; // its in the upper
      } else if (list(curIn) == element)
        return true
    }
    return false
  }
  override def toString: String = {
    var result = ""

    if (numberOfElement != 0) {

      for (i <- 0 to numberOfElement - 1) {
        result += list(i).toString + ", "
      }
    }

    result.dropRight(2)
  }
}
object IyteImmutableSet {
  
   def apply() = {
   new IyteImmutableSet
  }
  def apply(list: Array[Int]) = {
    val temp = new IyteImmutableSet()
    temp.list = list
    temp
  }

}