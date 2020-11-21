package xmht.zsda.handwriting.seven;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shengjk1
 * @date 2020/11/19
 */
public class TreeMaxWidth {
	
	public static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	//curEnd 和 nextEnd 来确定这一层的结束和下一层的结束
	public static int maxWidthNoMap(Node head) {
		if (head == null) {
			return 0;
		}
		// curEnd,nextEnd
		Node curEnd = head;
		Node nextEnd = null;
		int curLevelNodes = 0;
		int max = 0;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(head);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (cur.left != null) {
				queue.add(cur.left);
				nextEnd = cur.left;
			}
			if (cur.right != null) {
				queue.add(cur.right);
				nextEnd = cur.right;
			}
			curLevelNodes++;
			
			if (cur == curEnd) {
				max = Math.max(max, curLevelNodes);
				curLevelNodes = 0;
				curEnd = nextEnd;
			}
		}
		return max;
	}
}
