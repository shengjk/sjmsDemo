package xmht.zsda.handwriting.seven;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Code06_TreeMaxWidth {
	
	public static int maxWidthUseMap(Node head) {
		if (head == null) {
			return 0;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		HashMap<Node, Integer> levelMap = new HashMap<>();
		levelMap.put(head, 1);
		int curLevel = 1;
		int curLevelNodes = 0;
		int max = 0;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int curNodeLevel = levelMap.get(cur);
			if (cur.left != null) {
				levelMap.put(cur.left, curNodeLevel + 1);
				queue.add(cur.left);
			}
			if (cur.right != null) {
				levelMap.put(cur.right, curNodeLevel + 1);
				queue.add(cur.right);
			}
			if (curNodeLevel == curLevel) {
				curLevelNodes++;
			} else {
				max = Math.max(max, curLevelNodes);
				curLevel++;
				curLevelNodes = 1;
			}
		}
		max = Math.max(max, curLevelNodes);
		return max;
	}
	
	public static int maxWidthNoMap(Node head) {
		if (head == null) {
			return 0;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		Node curEnd = head;
		Node nextEnd = null;
		int max = 0;
		int curLevelNodes = 0;
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
	
	public static int maxWidth(Node head) {
		if (head == null) {
			return 0;
		}
		int max = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				Node poll = queue.poll();
				if (poll.left != null) {
					queue.add(poll.left);
				}
				if (poll.right != null) {
					queue.add(poll.right);
				}
			}
			max = Math.max(max, size);
		}
		return max;
	}
	
	// for test
	public static Node generateRandomBST(int maxLevel, int maxValue) {
		return generate(1, maxLevel, maxValue);
	}
	
	// for test
	public static Node generate(int level, int maxLevel, int maxValue) {
		if (level > maxLevel || Math.random() < 0.5) {
			return null;
		}
		Node head = new Node((int) (Math.random() * maxValue));
		head.left = generate(level + 1, maxLevel, maxValue);
		head.right = generate(level + 1, maxLevel, maxValue);
		return head;
	}
	
	public static void main(String[] args) {
		int maxLevel = 10;
		int maxValue = 100;
		int testTimes = 1000000;
		for (int i = 0; i < testTimes; i++) {
			Node head = generateRandomBST(maxLevel, maxValue);
			if (maxWidthUseMap(head) != maxWidth(head)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("finish!");
		
	}
	
	//每一层左右两个 node 之间的 node 数，包括 null 
	public int widthOfBinaryTree(Node root) {
		if (root == null) {
			return 0;
		}
		/// bfs, 利用完全二叉树的性质
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		LinkedList<Integer> numbers = new LinkedList<>();
		int max = 1;
		// 第一个节点的编号为1
		numbers.offer(1);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int index = numbers.poll();
				Node n = q.poll();
				if (n.left != null) {
					q.offer(n.left);
					numbers.offer(2 * index + 1);
				}
				if (n.right != null) {
					q.offer(n.right);
					numbers.offer(2 * index + 2);
				}
			}
			if (numbers.size() >= 2) {
				max = Math.max(max, numbers.getLast() - numbers.getFirst() + 1);
			}
			
		}
		return max;
	}
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
}
