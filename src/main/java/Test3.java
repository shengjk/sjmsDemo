/**
 * @author shengjk1
 * @date 2020/12/7
 */
public class Test3 {
	static class Node {
		private Node next;
		private int value;

		public Node(int value) {
			this.value = value;
		}

		public Node(int value, Node next) {
			this.next = next;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node{" +
					", value=" + value +
					'}';
		}
	}

	public static void main(String[] args) {
		Node head1 = new Node(1, null);
		head1.next = new Node(2, new Node(3, new Node(4)));

		Node head2 = new Node(1, null);
		head2.next = new Node(2, new Node(3, new Node(4)));


		Node tmp = head1;
		while (tmp != null) {
			System.out.println("head1" + tmp);
			tmp = tmp.next;
		}
		tmp = head2;
		while (tmp != null) {
			System.out.println("head2" + tmp);
			tmp = tmp.next;
		}

		System.out.println(findMedianSortedList(head1, head2));
	}

	public static double findMedianSortedList(Node head1, Node head2) {
		int m = 0;
		Node tmp = head1;
		while (tmp != null) {
			tmp = tmp.next;
			m++;
		}
		int n = 0;
		tmp = head2;
		while (tmp != null) {
			tmp = tmp.next;
			n++;
		}

		int left = (m + n + 1) / 2;
		int right = (m + n + 2) / 2;
		return (findKList(head1, m, 0, head2, n, 0, left) + findKList(head1, m, 0, head2, n, 0, right)) / 2.0;
	}

	public static int findKList(Node head1, int m, int i, Node head2, int n, int j, int k) {
		if (i >= m) {
			int count = 0;
			Node tmp = head2;
			while (tmp != null && count != j + k - 1) {
				count++;
				tmp = tmp.next;
			}
			return tmp.value;
		}
		if (j >= n) {
			int count = 0;
			Node tmp = head1;
			while (tmp != null && count != i + k - 1) {
				count++;
				tmp = tmp.next;
			}
			return tmp.value;
		}
		if (k == 1) {
			int count = 0;
			Node tmp2 = head2;
			while (tmp2 != null && count != j) {
				count++;
				tmp2 = tmp2.next;
			}
			count = 0;
			Node tmp = head1;
			while (tmp != null && count != i) {
				count++;
				tmp = tmp.next;
			}
			if (tmp != null && tmp2 != null) {
				return Math.min(tmp2.value, tmp.value);
			} else if (tmp == null && tmp2 != null) {
				return tmp2.value;
			} else {
				return tmp.value;
			}
		}


		int midVal1 = Integer.MAX_VALUE;
		if ((i + k / 2 - 1) < m) {
			int count = 0;
			Node tmp = head1;
			while (tmp != null && count != (i + k / 2 - 1)) {
				count++;
				tmp = tmp.next;
			}
			if (tmp != null) {
				midVal1 = tmp.value;
			}
		}

		int midVal2 = Integer.MAX_VALUE;
		if ((j + k / 2 - 1) < n) {
			int count = 0;
			Node tmp2 = head2;
			while (tmp2 != null && count != (j + k / 2 - 1)) {
				count++;
				tmp2 = tmp2.next;
			}
			if (tmp2 != null) {
				midVal2 = tmp2.value;
			}
		}
		if (midVal1 < midVal2) {
			return findKList(head1, m, i + k / 2, head2, n, j, k - k / 2);
		} else {
			return findKList(head1, m, i, head2, n, j + k / 2, k - k / 2);
		}
	}
}
