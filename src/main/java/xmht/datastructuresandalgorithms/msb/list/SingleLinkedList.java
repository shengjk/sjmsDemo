package xmht.datastructuresandalgorithms.msb.list;

/**
 * @author shengjk1
 * @date 2021/2/15
 */
public class SingleLinkedList {
	private Node head;


	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.add(new Node(1, null));
		singleLinkedList.add(new Node(2, null));
		singleLinkedList.add(new Node(3, null));
		singleLinkedList.add(new Node(4, null));

		Node head = singleLinkedList.getHead();
		singleLinkedList.dispaly(head);

		System.out.println("============");
//		singleLinkedList.dispaly(reverse(head));
		System.out.println("============");

		singleLinkedList.remove(4);
		singleLinkedList.dispaly(singleLinkedList.getHead());
	}

	//头插法
	public void add(Node node) {
		if (head == null) {
			head = node;
		} else {
			node.next = head;
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
			before = cur;
			cur = next;
		}
		return before;
	}


	public void remove(int value) {

		while (head != null && head.value == value) {
			head = head.next;
		}

		Node cur = head;
		while (cur.next != null) {
			if (cur.next.value == value) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
	}


	static class Node {
		private int  value;
		private Node next;

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
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
}
