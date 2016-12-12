class IyteHashTable() {
  val size: Int = 1000000
  val table: Array[Array[(String)]] = new Array[Array[(String)]] (size)
  var numOfElements: Int = 0

  def set(key: String,value: String): Unit = {
    val index = hash(key)

    if(table(index) == null){
      var arrayOfvalues = new Array[(String)](size)
      this.table(index) = arrayOfvalues
      arrayOfvalues(0) = value
      numOfElements = numOfElements + 1
    }   
    else{
      solveCollision(this.table(index),value) //collision
      numOfElements = numOfElements + 1     
    }
  }

  private def solveCollision(table: Array[(String)], value:String): Unit = {
      var index:Int = 0
      while(table(index) != null){
        index = index + 1
      }
      table(index) = value
  }

  def get(key: String): String = {
    val getIndex = hash(key)
    var str: String=""
    if(table(getIndex) == null){
      table(getIndex)
    }else{
      var insideIndex : Int = 0
      while(table(getIndex)(insideIndex) != null){
        str += table(getIndex)(insideIndex) + " - "
        insideIndex = insideIndex + 1
      }
    }
    str   
  }
  private def hash(key: String): Int = {
      var i: Int = 0
      var hash: Int = 0
      for( i <- 0 to key.length-1) {
        hash += key.charAt(i).toInt
        hash = hash *31
      }
      hash = hash % size
      hash
  }}


object IyteHashTable
{
  def apply() = new IyteHashTable()
}
