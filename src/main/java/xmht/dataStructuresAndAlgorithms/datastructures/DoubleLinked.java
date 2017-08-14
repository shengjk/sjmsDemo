package xmht.dataStructuresAndAlgorithms.datastructures;

/**
 * Created by shengjk1 on 2017/6/20 0020
 */
class Link{
	public long dData;
	public Link next;
	public Link previous;
	
	public Link(long d){
		dData=d;
	}
	
	public void displayLink(){
		System.out.println(dData+" ");
	}
}
class DoubleLinked {
	private Link first;
	private Link last;
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public void insertFirst(long dd){
		Link newLink=new Link(dd);
		if (isEmpty()){
			last=newLink;
		}else {
			first.previous=newLink;
			newLink.next=first;
		}
		first=newLink;
	}
	
	public void insertLast(long dd){
		Link newLink=new Link(dd);
		if (isEmpty()){
			first=newLink;
		}else {
			last.next=newLink;
			newLink.previous=last;
		}
		last=newLink;
		
	}
	
	public Link deleteFirst(){
		Link temp=first;
		if (first.next==null){
			last=null;
		}else{
			first.next.previous=null;
		}
		first=first.next;
		return temp;
	}
	
	
	public Link deleteLast(){
		Link temp=last;
		if (first.next==null){
			first=null;
		}else{
			last.previous.next=null;
		}
		last=last.previous;
		return temp;
	}
	
	public boolean insertAfter(long key,long dd){
		Link current=first;
		while (current.dData!=key){
			current=current.next;
		}
		return false;
	}
	
//	......
	
	public void displayList(){
	
	}
	

}
