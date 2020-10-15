package xmht.zsda.handwriting.six;

import java.util.HashMap;

/**
 * @author shengjk1
 * @date 2020/10/14
 */
public class CopyListWithRandom {
	public static Node copyListWithRandom1(Node head) {
		HashMap<Node, Node> nodeMap = new HashMap<>();
		Node cur = head;
		while (cur != null) {
			nodeMap.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		
		cur = head;
		while (cur != null) {
			nodeMap.get(cur).next = nodeMap.get(cur.next);
			nodeMap.get(cur).range = nodeMap.get(cur.range);
			cur = cur.next;
		}
		return nodeMap.get(head);
	}
	
	
	public static Node copyListWithRandom2(Node head) {
		Node cur = head;
		while (cur != null) {
			Node next = cur.next;
			Node newNode = new Node(cur.value);
			cur.next = newNode;
			newNode.next = next;
			cur = cur.next;
		}
		
		cur = head;
		while (cur != null) {
			Node curCopy = cur.next;
			curCopy.range = cur.range != null ? cur.range.next : null;
			cur = cur.next.next;
		}
		
		cur = head;
		Node newHead = cur.next;
		while (cur != null) {
			Node next = cur.next.next;
			Node copyNode = cur.next;
			copyNode.next = next != null ? next.next : null;
			cur.next = next;
			cur = next;
		}
		return newHead;
		
	}
	
	
	public static class Node {
		int value;
		Node next;
		Node range;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
}
