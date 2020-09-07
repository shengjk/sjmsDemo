package xmht.datastructuresandalgorithms.datastructure.LinkedList;

/**
 * @author shengjk1
 * @date 2020/9/5
 */
public class LinkedList {
	private Node head;
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add(new Node(1));
		linkedList.add(new Node(2));
		linkedList.add(new Node(3));
		linkedList.add(new Node(4));
		linkedList.foreach();

//		Node node = linkedList.reverseList();
	}
	
	public void add(Node node) {
		if (head == null) {
			head = node;
		}
		head.setNext(node);
	}
	
	public Node reverseList(Node head) {
		Node next = null;
		Node pre = null;
		while (head != null) {
			next = head.getNext();
			head.setNext(pre);
			pre = head;
			head = next;
		}
		return pre;
	}
	
	public void foreach() {
		Node current = head;
		while (current.getNext() != null) {
			System.out.println(current.getNext());
			current = current.getNext();
		}
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