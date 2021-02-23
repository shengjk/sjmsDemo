package xmht.datastructuresandalgorithms.msb.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shengjk1
 * @date 2021/2/19
 */
public class SerializeAndRecindtruncTree {
	static class Node {
		int  value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	//有node就是node没有node补充null
	public static void preSerial(Node head, Queue<String> ans) {

		if (head == null) {
			ans.add(null);
			return;
		}
		ans.add(String.valueOf(head.value));
		preSerial(head.left, ans);
		preSerial(head.right, ans);
	}

	public static Node buildTreeForPre(Queue<String> ans) {
		String value = ans.poll();
		if (value == null) {
			return null;
		}
		Node head = new Node(Integer.parseInt(value));
		head.left = buildTreeForPre(ans);
		head.right = buildTreeForPre(ans);
		return head;
	}

	public static void levelSerial(Node head) {
		Queue<Node> queue = new LinkedList<>();
		Queue<String> ans = new LinkedList<>();

		if (head == null) {
			ans.add(null);
		} else {
			ans.add(String.valueOf(head.value));
			queue.add(head);

			while (!queue.isEmpty()) {
				Node node = queue.poll();

				if (node.left != null) {
					queue.add(node.left);
					ans.add(String.valueOf(node.left.value));
				} else {
					ans.add(null);
				}

				if (node.right != null) {
					queue.add(node.right);
					ans.add(String.valueOf(node.right.value));
				} else {
					ans.add(null);
				}
			}
		}
	}

	public static void buildTreeFrolevel(Queue<String> ans) {
		String value = ans.poll();
		if (value == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		Node head = new Node(Integer.parseInt(value));
		queue.add(head);

		while (!queue.isEmpty()) {
			head = queue.poll();

			value = ans.poll();
			if (value != null) {
				head.left = new Node(Integer.parseInt(value));
				queue.add(head.left);
			}

			value = ans.poll();
			if (value != null) {
				head.right = new Node(Integer.parseInt(value));
				queue.add(head.right);
			}
		}
	}
}
