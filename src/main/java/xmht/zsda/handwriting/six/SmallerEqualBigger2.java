package xmht.zsda.handwriting.six;

/**
 * @author shengjk1
 * @date 2020/10/14
 */

public class SmallerEqualBigger2 {
	
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
		head1 = smallerEqualBigger(head1, 5);
		printLinkedList(head1);
		
	}
	
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	// 将链表转化为数组
	public static void netherlandsFlag(int[] arr, int L, int R) {
		int less = L - 1;
		int more = R;
		int eq = arr[R];
		int index = 0;
		
		// 小于和大于交换
		while (index < more) {
			if (arr[index] < arr[R]) {
				swap(arr, index++, ++less);
			} else if (arr[index] > arr[R]) {
				swap(arr, index, --R);
			} else {
				index++;
			}
		}
	}
	
	// i 与 j 交换
	public static void swap(int[] arr, int i, int j) {
		int temp = i;
		i = j;
		j = temp;
	}
	// 直接链表
	
	public static Node smallerEqualBigger(Node head, int j) {
		if (head == null) {
			return null;
		}
		Node lessNodeHead = null;
		Node lessNodeTail = null;
		
		Node equalNodeHead = null;
		Node equalNodeTail = null;
		
		Node moreNodeHead = null;
		Node moreNodeTail = null;
		
		while (head != null) {
			Node next = head.next;
			head.next = null;
			if (head.value < j) {
				if (lessNodeHead == null) {
					lessNodeHead = head;
					lessNodeTail = head;
				} else {
					lessNodeTail.next = head;
					lessNodeTail = head;
				}
			} else if (head.value == j) {
				if (equalNodeHead == null) {
					equalNodeHead = head;
					equalNodeTail = head;
				} else {
					equalNodeHead.next = head;
					equalNodeTail = head;
				}
			} else {
				if (moreNodeHead == null) {
					moreNodeHead = head;
					moreNodeTail = head;
				} else {
					moreNodeTail.next = head;
					moreNodeTail = head;
				}
			}
			head = next;
		}
		
		if (lessNodeHead != null) {
			lessNodeTail.next = equalNodeHead;
			equalNodeHead = equalNodeHead == null ? lessNodeTail : equalNodeHead;
		}
		
		if (equalNodeHead != null) {
			equalNodeTail.next = moreNodeHead;
		}
		
		return lessNodeHead == null ? (equalNodeHead == null ? equalNodeHead : moreNodeHead) : lessNodeHead;
	}
	
	
	public static class Node {
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
		
	}
}
