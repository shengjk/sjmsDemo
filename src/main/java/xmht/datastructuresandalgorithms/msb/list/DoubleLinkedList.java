package xmht.datastructuresandalgorithms.msb.list;

/**
 * @author shengjk1
 * @date 2021/2/15
 */
public class DoubleLinkedList {
	private Node head;


	public static void main(String[] args) {
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(new Node(1, null, null));
		doubleLinkedList.add(new Node(2, null, null));
		doubleLinkedList.add(new Node(3, null, null));
		doubleLinkedList.add(new Node(4, null, null));

		Node head = doubleLinkedList.getHead();
		doubleLinkedList.dispaly(head);

		System.out.println("============");
		doubleLinkedList.dispaly(reverse(head));
	}

	//头插法
	public void add(Node node) {
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head.pre = node;

			head = node;
		}
	}

	public void dispaly(Node head) {
		Node cur = head;
		while (cur != null) {
			System.out.println(cur);
			cur = cur.next;

		}
	}

	public Node getHead() {
		return this.head;
	}

	public static Node reverse(Node head) {
		Node cur = head;
		Node before = null;
		Node next = null;

		while (cur != null) {
			next = cur.next;
			cur.next = before;
			cur.pre = next;
			before = cur;
			cur = next;
		}
		return before;
	}


	static class Node {
		@Override
		public String toString() {
			return "Node{" +
					"value=" + value +
//					", next=" + next +
					", pre=" + pre +
					'}';
		}

		private int  value;
		private Node next;
		private Node pre;

		public Node(int value, Node next, Node pre) {
			this.value = value;
			this.next = next;
			this.pre = pre;
		}

	}
}
