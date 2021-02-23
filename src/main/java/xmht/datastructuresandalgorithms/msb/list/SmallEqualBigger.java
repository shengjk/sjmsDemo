package xmht.datastructuresandalgorithms.msb.list;

/**
 * @author shengjk1
 * @date 2021/2/17
 */
public class SmallEqualBigger {

	static class Node {
		int  value;
		Node next;

		public Node(int value) {
			this.value = value;
		}
	}


	public static Node listPartition2(Node head, int num) {
		Node sHead = null;
		Node sTail = null;
		Node eHead = null;
		Node eTail = null;
		Node bHead = null;
		Node bTail = null;

		Node curNode = head;
		Node next = null;
		while (curNode != null) {
			next = curNode.next;
			curNode.next = null;

			if (curNode.value < num) {
				if (sHead == null) {
					sHead = curNode;
					sTail = curNode;
				} else {
					curNode.next = sHead;
					sHead = curNode;
				}
			} else if (curNode.value == num) {
				if (eHead == null) {
					eHead = curNode;
					eTail = curNode;
				} else {
					curNode.next = eHead;
					eHead = curNode;
				}
			} else {
				if (bHead == null) {
					bHead = curNode;
					bTail = curNode;
				} else {
					curNode.next = bHead;
					bHead = curNode;
				}
			}

			curNode = next;
		}


		if (sTail != null) {
			sTail.next = eHead;
			eTail = eTail == null ? sTail : eTail;
		}

		if (eTail != null) {
			eTail.next = bHead;
		}

		return sHead != null ? sHead : (eHead != null ? eHead : bHead);

	}

	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		printLinkedList(head1);
		// head1 = listPartition1(head1, 4);
		head1 = listPartition2(head1, 5);
		printLinkedList(head1);

	}
}
