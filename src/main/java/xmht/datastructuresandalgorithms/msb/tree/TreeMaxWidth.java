package xmht.datastructuresandalgorithms.msb.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shengjk1
 * @date 2021/2/19
 */
public class TreeMaxWidth {

	static class Node {
		int  value;
		Node left;
		Node right;
	}

	public static int treeMaxWidth(Node head) {
		if (head == null) {
			return 0;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		Node curEnd = head;
		Node nextEnd = null;
		int max = 0;
		int levelNodes = 0;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.left != null) {
				queue.offer(cur.left);
				nextEnd = cur.left;
			}

			if (cur.right != null) {
				queue.offer(cur.right);
				nextEnd = cur.right;
			}

			levelNodes++;
			if (cur == curEnd) {
				max = Math.max(max, levelNodes);
				levelNodes = 0;
				curEnd = nextEnd;
			}
		}
		return max;
	}
}
