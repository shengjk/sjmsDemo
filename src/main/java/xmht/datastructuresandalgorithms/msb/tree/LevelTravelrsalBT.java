package xmht.datastructuresandalgorithms.msb.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shengjk1
 * @date 2021/2/19
 */
public class LevelTravelrsalBT {

	static class Node {
		int  value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void levelTravelrsal(Node head) {
		if (head == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(head);

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.println(node.value);

			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}


	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		levelTravelrsal(head);
		System.out.println("========");
	}

}
