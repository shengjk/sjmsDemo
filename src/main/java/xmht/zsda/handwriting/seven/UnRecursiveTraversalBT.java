package xmht.zsda.handwriting.seven;

import java.util.Stack;

/**
 * @author shengjk1
 * @date 2020/10/21
 */
public class UnRecursiveTraversalBT {
	
	//前序遍历，先右后左
	public static void pre(Node head) {
		if (head == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		while (!stack.isEmpty()) {
			head = stack.pop();
			System.out.println(head);
			if (head.right != null) {
				stack.push(head.right);
			}
			if (head.left != null) {
				stack.push(head.left);
			}
		}
	}
	
	//后序遍历，先左后右
	public static void pos(Node head) {
		if (head == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		Stack<Node> result = new Stack<>();
		stack.push(head);
		while (!stack.isEmpty()) {
			head = stack.pop();
			result.push(head);
			if (head.left != null) {
				stack.push(head.left);
			}
			if (head.right != null) {
				stack.push(head.right);
			}
		}
		while (!result.isEmpty()) {
			System.out.println(result.pop());
		}
	}
	
	
	//中序遍历，一左到底 再写
	public static void in(Node head) {
		if (head == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		while (!stack.isEmpty() || head != null) {
			if (head != null) {
				stack.push(head);
				head = head.left;
			} else {
				head = stack.pop();
				System.out.println(head);
				head = head.right;
			}
		}
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

