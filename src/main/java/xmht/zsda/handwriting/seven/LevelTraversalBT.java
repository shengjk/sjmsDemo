package xmht.zsda.handwriting.seven;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
	public static void Jagged(Node head) {
		if (head == null) {
			
		}
		int cout = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(head);
		while (!queue.isEmpty()) {
			//当前层的大小，也可以用来求最大宽度
			int size = queue.size();
			ArrayList<Node> nodes = new ArrayList<Node>();
			for (int i = 0; i < size; i++) {
//				nodes.
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

