package xmht.zsda.handwriting;

/**
 * @author shengjk1
 * @date 2020/10/4
 */
public class LinkedList {
	
	private Node head;
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.disPaly();
		linkedList.reveseList();
		System.out.println("=====+");
		linkedList.disPaly();
		
	}
	
	public void add(int value) {
		if (head == null) {
			head = new Node(value);
		} else {
			Node Temp = head;
			while (Temp.getNext() != null) {
				Temp = Temp.getNext();
			}
			Temp.setNext(new Node(value));
		}
	}
	
	public void disPaly() {
		Node Temp = head;
		while (Temp != null) {
			System.out.println(Temp);
			Temp = Temp.getNext();
		}
	}
	
	public void reveseList() {
		Node pre = null;
		Node cur = head;
		Node next;
		while (cur != null) {
			next = cur.getNext();
			cur.setNext(pre);
			pre = cur;
			cur = next;
		}
		head = pre;
	}
	
	public void reveseList(Node head) {
		Node pre = null;
		Node cur = head;
		Node next;
		while (cur != null) {
			next = cur.getNext();
			cur.setNext(pre);
			pre = cur;
			cur = next;
		}
		head = pre;
	}
}

class Node {
	private int value;
	private Node next;
	
	public Node(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "Node{" +
				"value=" + value +
				", next=" + next +
				'}';
	}
}
