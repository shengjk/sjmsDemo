package xmht.datastructuresandalgorithms.msb.list;

import java.util.Stack;

/**
 * @author shengjk1
 * @date 2021/2/17
 */
public class PalindromeList {

	static class Node {
		int  value;
		Node next;

		public Node(int value) {
			this.value = value;
		}
	}


	//借助栈的特性：先进后出
	public boolean isPalindrome(Node head) {
		if (head == null) {
			return false;
		}

		//最终 rightNode 为上中点
		Node rightNode = head.next;
		Node curNode = head;
		while (curNode.next != null & curNode.next.next != null) {
			rightNode = rightNode.next;
			curNode = curNode.next.next;
		}

		//将后半部分放入栈中
		Stack<Node> nodesStack = new Stack<>();
		while (rightNode != null) {
			nodesStack.push(rightNode);
			rightNode = rightNode.next;
		}

		rightNode = head;
		while (!nodesStack.isEmpty()) {
			if (rightNode.value != nodesStack.pop().value) {
				return false;
			}
			rightNode = rightNode.next;
		}
		return true;
	}


	//反转链表
	public boolean isPalindrome2(Node head) {
		if (head == null) {
			return false;
		}

		//最终 rightNode 为上中点
		Node rightNode = head.next;
		Node curNode = head;
		while (curNode.next != null & curNode.next.next != null) {
			rightNode = rightNode.next;
			curNode = curNode.next.next;
		}

		//下中点
		Node next = curNode.next;
		curNode.next = null;
		curNode = next;
		Node newHeadNode = reverse(curNode);

		while (head != null && newHeadNode != null) {
			if (head.value != newHeadNode.value) {
				return false;
			}
		}
		return true;

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
}
