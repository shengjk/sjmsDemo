package xmht.zsda.handwriting.seven;

import java.util.Stack;

/**
 * @author shengjk1
 * @date 2020/10/30
 */
// 需要再写
public class UnRecursiveTraversalBT {
	/*
	前序非递归，手动压栈
	与递归类似，只是先右后左
	 */
	public static void pre(Node head) {
		if (head == null) {
			return;
		}
		Stack<Node> ans = new Stack<>();
		ans.push(head);
		while (!ans.isEmpty()) {
			head = ans.pop();
			System.out.println(head);
			
			if (head.right != null) {
				ans.push(head.right);
			}
			if (head.left != null) {
				ans.push(head.left);
			}
		}
	}
	
	/*
	 后序与前序遍历，头节点都是正常的，关键在于左右节点的位置，其实与后序前序递归遍历挺像的
	 */
	public static void pos(Node head) {
		if (head == null) {
			return;
		}
		Stack<Node> result = new Stack<>();
		Stack<Node> ans = new Stack<>();
		ans.add(head);
		
		while (!ans.isEmpty()) {
			head = ans.pop();
			result.push(head);
			
			if (head.left != null) {
				ans.push(head.left);
			}
			if (head.right != null) {
				ans.push(head.right);
			}
		}
		while (!result.isEmpty()) {
			System.out.println(result.pop());
		}
	}
	
	/*
	先一左到底，然后only 左添加到 stack 中
	 */
	public static void in(Node head) {
		if (head == null) {
			return;
		}
		Stack<Node> ans = new Stack<>();
		
		while (!ans.isEmpty() || head != null) {
			if (head != null) {
				ans.push(head);
				head = head.left;
			} else {
				head = ans.pop();
				System.out.println(head);
				head = head.right;
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
