package xmht.dataStructuresAndAlgorithms.datastructures;

/**
 * Created by shengjk1 on 2017/6/19 0019
 */
class Link1 {
	public int iData;
	public double dData;
	public Link1 next;
	
	public Link1(int id,double dd){
		iData=id;
		dData=dd;
	}
	
	public void displayLink(){
		System.out.println("{"+iData +","+ dData+"}");
	}
}

class LinkList{
	private Link1 first;
	
	public void LinkList(){
		first=null;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public void insertFirst(int id,double dd){
		Link1 newLink=new Link1(id,dd);
		newLink.next=first;
		first=newLink;
	}
	
	public Link1 deleteFirst(){
		Link1 temp=first;
		first=first.next;
		return temp;
	}
	
	public Link1 find(int key){
		Link1 current=first;
		while (current.iData!=key){
			if(current.next==null){
				return null;
			}else {
				current=current.next;
			}
		}
		return current;
	}
	
	public Link1 delete(int key){
		Link1 current=first;
		Link1 previous=first;
		while (current.iData!=key){
			if (current.next==null){
				return null;
			}else {
				previous=current;
				current=current.next;
			}
		}
		if (current==first){
			first=first.next;
		}else {
			previous.next=current.next;
		}
		return current;
	}
	
	public void displayList(){
		System.out.println("list first----->last");
		Link1 current=first;
		while (current!=null){
			current.displayLink();
			current=current.next;
		}
	}
	
	
}

class LinkListApp{
	public static void main(String[] args) {
		LinkList linkList=new LinkList();
		linkList.insertFirst(22,2.99);
		linkList.insertFirst(224,2.994);
		linkList.insertFirst(226,2.996);
		linkList.insertFirst(228,2.998);
		
		linkList.displayList();
		
		linkList.find(221).displayLink();
//		linkList.displayList();
	}
}
