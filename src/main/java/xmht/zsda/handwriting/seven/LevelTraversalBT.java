package xmht.zsda.handwriting.seven;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shengjk1
 * @date 2020/10/21
 */
public class LevelTraversalBT {
	
	public static void level(Node head) {
		if (head == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur);
			
			if (cur.left != null) {
				queue.offer(cur.left);
			}
			
			if (cur.right != null) {
				queue.offer(cur.right);
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
		
		level(head);
		System.out.println("========");
	}
	
	public static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Node{" +
					"value=" + value +
					'}';
		}
	}
}
