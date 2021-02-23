package xmht.datastructuresandalgorithms.msb.list;

/**
 * @author shengjk1
 * @date 2021/2/17
 */
public class CopyListWithRandom {
	static class Node {
		int  value;
		Node next;
		Node rand;

		Node(int val) {
			value = val;
		}
	}


	public Node copyListWithRandom(Node head) {
		if (head == null) {
			return null;
		}

//		1->2
//		1->'1'->2 ->'2'
		Node curNode = head;
		while (curNode != null) {
			Node node = new Node(curNode.value);

			Node next = curNode.next;
			curNode.next = node;
			node.next = next;
			curNode = next;
		}

		//rand 节点
		curNode = head;
		while (curNode != null) {
			Node copyNode = curNode.next;
			copyNode.rand = curNode.rand == null ? curNode.rand : curNode.rand.next;
			curNode = curNode.next.next;
		}

		curNode = head;
		Node newHead = head.next;
		while (curNode != null) {
			Node next = curNode.next.next;
			Node copyNode = curNode.next;

			curNode.next = next;
			copyNode.next = next != null ? next.next : null;

			curNode = next;
		}

		return newHead;
	}
}
