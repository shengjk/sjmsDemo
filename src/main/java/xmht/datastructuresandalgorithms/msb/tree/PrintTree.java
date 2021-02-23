package xmht.datastructuresandalgorithms.msb.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shengjk1
 * @date 2021/2/19
 */
public class PrintTree {
	static class Node {
		int  value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void printTree(Node head) {


		Queue<Node> queue = new LinkedList<>();

		Node curEnd = head;
		Node nextCurEnd = null;
		int levelCount = 0;

		queue.add(head);

		Node cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			System.out.print(getSpace(levelCount) + cur.value);

			if (cur.left != null) {
				queue.add(cur.left);
				nextCurEnd = cur.left;
			}

			if (cur.right != null) {
				queue.add(cur.right);
				nextCurEnd = cur.right;
			}
			if (cur != curEnd) {
				System.out.println();
			} else {
				levelCount++;
				curEnd = nextCurEnd;
			}
		}
		System.out.println();
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}


	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(-222222222);
		head.right = new Node(3);
		head.left.left = new Node(Integer.MIN_VALUE);
		head.right.left = new Node(55555555);
		head.right.right = new Node(66);
		head.left.left.right = new Node(777);
		printTree(head);
		System.out.println("=====================");

		head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.left = new Node(5);
		head.right.right = new Node(6);
		head.left.left.right = new Node(7);
		printTree(head);
		System.out.println("=====================");

		head = new Node(1);
		head.left = new Node(1);
		head.right = new Node(1);
		head.left.left = new Node(1);
		head.right.left = new Node(1);
		head.right.right = new Node(1);
		head.left.left.right = new Node(1);
		printTree(head);

	}

}
