
trait RandomStuffTrait {
  def transform(list: List[Int], op: (Int) => Int): List[Int];
  def allValid(list: List[Int], op: (Int) => Boolean): Boolean;
  def executeWithRetry(retryCount: Int, op: => Int): Option[Int];
}
object RandomStuff extends RandomStuffTrait {
  
  def transform(list: List[Int], op: (Int) => Int): List[Int] = {
    var transformer: List[Int] = List();
    for (x <- list) {
      transformer = transformer :+ op(x)
    }
    transformer;
  }
 
  def allValid(list: List[Int], op: (Int) => Boolean): Boolean = {
    list.foreach(x => if (!op(x)) {
      return false
    });
    true
  }

  def executeWithRetry(retryCount: Int, op: => Int): Option[Int] = {
    for (i <- 1 to retryCount) {
      try {
        return Option(op)
      } catch {
        case ex: Exception => {
        }
      }
    }
    None;
  }
}