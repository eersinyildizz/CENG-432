class IyteMutableList {
  class Node(var data:Int, var next: Node)
  private var head: Node = null
  private var last: Node = null
  
  def add( data: Int): {
    if(head==null){
      head= new Node(data,null)
      last=head
    }else{
      last.next=new Node(data,null)
      last=last.next

    }
  }
  override def toString: String= {
    var result:String = ""
    var temp = head
    while(temp.next !=null){
      result=result+temp.data+","
      
      temp=temp.next
    }
      result=result+last.data
      result
  }
}
object  IyteMutableList{
  def apply(): IyteMutableList = new IyteMutableList()
}