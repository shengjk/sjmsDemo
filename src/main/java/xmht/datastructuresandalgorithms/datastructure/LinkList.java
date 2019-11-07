package xmht.datastructuresandalgorithms.datastructure;

/**
 * @author shengjk1
 * @date 2019-07-01
 */
public class LinkList {
	private Link last;
	private Link first;
	
	
	public void InsertFirst(Link link) {
		
		if (first == null) {
			first = link;
		}
		link.setNext(last);
		last = link;
	}
	
	public void InsertOrder(Link link) {
		Link currentNode;
		Link previousNode;
		
		if (last == null) {
			link.setNext(last);
			last = link;
			return;
		}
		currentNode = last;
		previousNode=last;
		
		while (currentNode.getNext() != null) {
			if (currentNode.getiData() >= link.getiData()) {
				link.setNext(currentNode);
				previousNode.setNext(link);
				return;
			}
			previousNode=currentNode;
			currentNode=currentNode.getNext();
		}
		if (currentNode.getiData() >= link.getiData()) {
			link.setNext(currentNode);
			previousNode.setNext(link);
		} else {
			link.setNext(null);
			currentNode.setNext(link);
		}
	}
	
	
	public void deleteFirst() {
		Link temp = last;
		last = null;
		last = temp.getNext();
	}
	
	public Link delete(int i) {
		Link temp = last;
		if (last.getiData() == i) {
			last = last.getNext();
			return temp;
		}
		
		while (temp != null && temp.getNext() != null) {
			if (temp.getNext().getiData() == i) {
				temp.setNext(temp.getNext().getNext());
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}
	
	public Link reverse(LinkList linkList) {
		Link current = linkList.last;
		Link next = null;
		Link temp = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(temp);
			temp = current;
			current = next;
		}
		last=temp;
		return temp;
	}
	
	public void disPlay() {
		Link temp = last;
		while (temp != null) {
			temp.displayLink();
			temp = temp.getNext();
		}
	}
}

class LinkListApp {
	public static void main(String[] args) {
		LinkList linkList = new LinkList();
		
		linkList.InsertOrder(new Link(1));
		linkList.InsertOrder(new Link(21));
		linkList.InsertOrder(new Link(3));
		linkList.InsertOrder(new Link(4));

//			linkList.deleteFirst();
//			linkList.deleteFirst();
//			linkList.deleteFirst();

//		linkList.delete(4);
//
		linkList.disPlay();
		System.out.println("==========+");
		Link reverse = linkList.reverse(linkList);
		reverse.displayLink();
		while (reverse.getNext() != null) {
			reverse.getNext().displayLink();
			reverse = reverse.getNext();
		}
		
		System.out.println("===============");
		linkList.disPlay();
	}
}

/**
 * 在链表中，每个数据项都包含在 链接点 中。一个链接点是某个类的对象 Link
 * 一个链表中有许多类似的链接点，所有有必要用一个不同于链表的类来表达链接点
 * 每一个Link对象中都包含一个对下一个链接点引用的字段(next)
 * 但是链表本身的对象中有一个字段指向对第一个链接点的引用
 */
class Link {
	private int iData;
	private double dData;
	private Link next;
	
	public Link(int iData) {
		this.iData = iData;
		this.dData = iData;
	}
	
	public int getiData() {
		return iData;
	}
	
	public void setiData(int iData) {
		this.iData = iData;
	}
	
	public double getdData() {
		return dData;
	}
	
	public void setdData(double dData) {
		this.dData = dData;
	}
	
	public Link getNext() {
		return next;
	}
	
	public void setNext(Link next) {
		this.next = next;
	}
	
	public void displayLink() {
		System.out.println("Link{" +
				"iData=" + iData +
				", dData=" + dData +
				", next=" + next +
				'}');
	}
}
