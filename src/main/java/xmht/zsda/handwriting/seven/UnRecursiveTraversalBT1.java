package xmht.zsda.handwriting.seven;

import java.util.Stack;

/**
 * @author shengjk1
 * @date 2020/10/30
 */

public class UnRecursiveTraversalBT1 {
	
	/*
	 前序非递归，与递归类似，不过先右后左
	 */
	public static void pre(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> ans = new Stack<>();
		ans.add(root);
		while (!ans.isEmpty()) {
			root = ans.pop();
			System.out.println(root);
			
			if (root.right != null) {
				ans.add(root.right);
			}
			if (root.left != null) {
				ans.add(root.left);
			}
		}
	}
	
	/*
	后序遍历，需要两个栈，先左后右
	 */
	public static void pos(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> result = new Stack<>();
		Stack<Node> ans = new Stack<>();
		ans.add(root);
		while (!ans.isEmpty()) {
			root = ans.pop();
			result.push(root);
			if (root.left != null) {
				ans.push(root.left);
			}
			if (root.right != null) {
				ans.push(root.right);
			}
		}
		while (!result.isEmpty()) {
			System.out.println(result.pop());
		}
	}
	
	/*
	中序遍历，一左到底
	 */
	public static void in(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> ans = new Stack<>();
		ans.push(root);
		while (!ans.isEmpty() || root != null) {
			if (root != null) {
				ans.push(root);
				root = root.left;
			} else {
				root = ans.pop();
				System.out.println(root);
				root = root.right;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		System.out.println("====pre====");
		pre(root);
		System.out.println("====in====");
		in(root);
		System.out.println("====pos====");
		pos(root);
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
