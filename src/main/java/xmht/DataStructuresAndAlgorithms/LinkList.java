package xmht.DataStructuresAndAlgorithms;

/**
 * Created by shengjk1 on 2017/5/22 0022
 */

class Link {
	public int IData;
	public double dData;
	public Link next;
	
	public Link(int id, double dd) {
		IData = id;
		dData = dd;
	}
	
	public void displayLink() {
		System.out.println("{ " + IData + " , " + dData + " } ");
	}
}

class LinkList {
	private Link first;
	
	public LinkList() {
		first = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(int id, double dd) {
		Link newLink = new Link(id, dd);
		newLink.next = first;
		first = newLink;
	}
	
	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	
	public Link find(int key) {
		Link current = first;
		while (current.IData != key) {
			if(current.next==null){
				return null;
			}else {
				current=current.next;
			}
		}
		return current;
	}
	
	public Link delete(int key){
		Link current=first;
		Link previous=first;
		while (current.IData!=key){
			if(current.next==null){
				return null;
			}else {
				previous=current;
				current=current.next;
			}
		}
		if(current==first){
			first=first.next;
		}else {
			previous.next=current.next;
		}
		return current;
	}
	
	public void displayList() {
		System.out.println("List (first--->last)");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}
}

class LinkListApp {
	public static void main(String[] args) {
		LinkList linkList = new LinkList();
		linkList.insertFirst(22, 2.99);
		linkList.insertFirst(224, 42.99);
		linkList.insertFirst(226, 62.99);
		linkList.insertFirst(228, 28.99);
		linkList.displayList();
		
		linkList.displayList();
		
		System.out.println();
		linkList.find(224).displayLink();
		linkList.delete(224);
		linkList.displayList();
	}
}


