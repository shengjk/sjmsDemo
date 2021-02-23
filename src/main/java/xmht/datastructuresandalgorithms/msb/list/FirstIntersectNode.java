package xmht.datastructuresandalgorithms.msb.list;

/**
 * @author shengjk1
 * @date 2021/2/17
 */
public class FirstIntersectNode {
	static class Node {
		int  values;
		Node next;
	}


	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);

		if (loop1 == null && loop2 == null) {
			return getNoLoopNode(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}

	public static boolean isRing(Node head) {
		boolean isRing = false;

		Node curNode = head;
		Node nextCurNode = head;

		while (nextCurNode.next != null && nextCurNode.next.next != null) {
			if (curNode.values == nextCurNode.values) {
				isRing = true;
				break;
			}
			curNode = curNode.next;
			nextCurNode = nextCurNode.next.next;
		}
		return isRing;
	}


	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}

		Node sNode = head.next;
		Node fNode = head.next.next;

		while (sNode != fNode) {
			if (fNode.next == null || fNode.next.next == null) {
				return null;
			}
			sNode = sNode.next;
			fNode = fNode.next.next;
		}

		fNode = head;

		while (fNode != sNode) {
			fNode = fNode.next;
			sNode = sNode.next;
		}
		return sNode;
	}


	public static Node getNoLoopNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}

		Node cur1 = head1;
		Node cur2 = head2;
		int n = 0;
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}

		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {
			return null;
		}

		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);

		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}

		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}


	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;

		if (loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}

			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}

			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);

			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}

			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}

}
