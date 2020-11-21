package xmht.zsda.handwriting.seven;

import java.util.*;

/**
 * @author shengjk1
 * @date 2020/10/30
 */
public class LevelTraversalBT {
	//层序遍历
	public static void levelTraver(Node head) {
		if (head == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			System.out.println(head);
			if (head.left != null) {
				queue.add(head.left);
			}
			if (head.right != null) {
				queue.add(head.right);
			}
		}
	}
	
	//锯齿遍历
	public List<List<Integer>> zigzagLevelOrder(Node root) {
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		if (root == null) {
			return lists;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			// 需要一个 list 做缓存，依据 count 来判断是否反转
			ArrayList<Integer> integers = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				root = queue.poll();
				integers.add(root.val);
				
				if (root.left != null) {
					queue.add(root.left);
				}
				if (root.right != null) {
					queue.add(root.right);
				}
			}
			if (count % 2 != 0) {
				Collections.reverse(integers);
			}
			lists.add(integers);
			count++;
		}
		return lists;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		
		levelTraver(head);
		System.out.println("========");
	}
	
	public static class Node {
		int val;
		Node left;
		Node right;
		
		public Node(int val) {
			this.val = val;
		}
		
		@Override
		public String toString() {
			return "Node{" +
					"val=" + val +
					'}';
		}
	}
	
}

