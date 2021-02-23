package xmht.datastructuresandalgorithms.msb.tree;

import java.util.Stack;

/**
 * @author shengjk1
 * @date 2021/2/18
 */
public class UnRecursiveTraversalBT {
	static class Node {
		int  value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	/*
	栈不为空即弹出，弹出即打印
	先压头结点
	再压右节点
	压左节点
	 */
	public static void pre(Node head) {
		// 头左右
		Stack<Node> stack = new Stack<>();

		stack.push(head);

		while (!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.println(node);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}


	public static void pos(Node head) {
		//头右左
		Stack<Node> stack = new Stack<>();
		//左右头
		Stack<Node> help = new Stack<>();

		stack.push(head);
		while (!stack.isEmpty()) {
			Node pop = stack.pop();
			help.push(pop);
			if (pop.left != null) {
				stack.push(pop.left);
			}
			if (pop.right != null) {
				stack.push(pop.right);
			}
		}
		while (!help.isEmpty()) {
			System.out.println(help.pop());
		}
	}


	/*
	先一左到底，然后only 左添加到 stack 中
	 */
	public static void in(Node head) {
		Stack<Node> nodeStack = new Stack<>();

		while (!nodeStack.isEmpty() || head != null) {
			if (head != null) {
				nodeStack.push(head);
				head = head.left;
			} else {
				head = nodeStack.pop();
				System.out.println(head);
				head = head.right;
			}
		}
	}
}
