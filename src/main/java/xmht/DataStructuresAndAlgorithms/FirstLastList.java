package xmht.DataStructuresAndAlgorithms;

/**
 * Created by shengjk1 on 2017/5/23 0023
 */
//双端链表

class Link1{
	public long dData;
	public Link1 next;
	
	public Link1(long dData) {
		this.dData = dData;
	}
	
	public void displayLink(){
		System.out.println(dData+"");
	}
}

class FirstLastList{
	private Link1 first;
	private Link1 last;
	
	public FirstLastList() {
		first=null;
		last=null;
	}
	public boolean isEmpty(){
		return first==null;
	}
	public void insertFirst(long dd){
		Link1 link1=new Link1(dd);
		if(isEmpty()){
			last=link1;
		}
		link1.next=first;
		first=link1;
	}
	public void insertLast(long dd){
		Link1 link1=new Link1(dd);
		if(isEmpty()){
			first=link1;
		}else {
			last.next=link1;
		}
		last=link1;
	}
	public long deleteFirst(){
		long temp =first.dData;
		if(first.next==null){
			last=null;
		}
		first=first.next;
		return temp;
	}
	public void displayList(){
		System.out.println("List (first---->last):");
		Link1 current=first;
		while (current!=null){
			current.displayLink();
			current=current.next;
		}
	}
}

class FirstLastApp{
	public static void main(String[] args) {
		FirstLastList list=new FirstLastList();
		list.insertFirst(22);
		list.insertFirst(224);
		list.insertFirst(226);
		
		list.insertLast(11);
		list.insertLast(113);
		list.insertLast(115);
		
		list.displayList();
		
		list.deleteFirst();
		list.deleteFirst();
		list.displayList();
	}
}
