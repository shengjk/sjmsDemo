package xmht.zsda.handwriting.eight;

import java.util.ArrayList;

/**
 * @author shengjk1
 * @date 2020/11/19
 */
/*
给定一棵二叉树的头节点head，
返回这颗二叉树中最大的二叉搜索子树的头结点

 */
public class MaxSubBSTHead1 {
	public static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static class Info {
		Node maxSubBSTHead;
		int maxSubBSTSize;
		int min;
		int max;
		
		public Info(Node maxSubBSTHead, int maxSubBSTSize, int min, int max) {
			this.maxSubBSTHead = maxSubBSTHead;
			this.maxSubBSTSize = maxSubBSTSize;
			this.min = min;
			this.max = max;
		}
	}
	
	public static Info process(Node x) {
		if (x == null) {
			return null;
		}
		Info leftInfo = process(x.left);
		Info rightInfo = process(x.right);
		
		Node maxSubBSTHead = null;
		int min = x.value, max = x.value;
		int maxSubBSTSize = 0;
		
		if (leftInfo != null) {
			min = Math.min(min, leftInfo.min);
			max = Math.max(max, leftInfo.max);
			maxSubBSTSize = leftInfo.maxSubBSTSize;
			maxSubBSTHead = leftInfo.maxSubBSTHead;
		}
		
		if (rightInfo != null) {
			min = Math.min(min, rightInfo.min);
			max = Math.max(max, rightInfo.max);
			//最大二叉搜索树的 head
			if (rightInfo.maxSubBSTSize > maxSubBSTSize) {
				maxSubBSTSize = rightInfo.maxSubBSTSize;
				maxSubBSTHead = rightInfo.maxSubBSTHead;
			}
		}
		
		//想把 x 赋值给 maxSubBSTHead
		if ((leftInfo == null ? true : (leftInfo.maxSubBSTHead == x.left && leftInfo.max < x.value))
				&& (rightInfo == null ? true : (rightInfo.maxSubBSTHead == x.right && rightInfo.min > x.value))) {
			
			maxSubBSTHead = x;
			maxSubBSTSize = ((leftInfo == null) ? 0 : leftInfo.maxSubBSTSize) +
					(rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
		}
		
		return new Info(maxSubBSTHead, maxSubBSTSize, min, max);
		
		
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
		int maxLevel = 4;
		int maxValue = 100;
		int testTimes = 1000000;
		for (int i = 0; i < testTimes; i++) {
			Node head = generateRandomBST(maxLevel, maxValue);
			if (maxSubBSTHead1(head) != maxSubBSTHead2(head)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("finish!");
	}
	
	public static int getBSTSize(Node head) {
		if (head == null) {
			return 0;
		}
		ArrayList<Node> arr = new ArrayList<>();
		in(head, arr);
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i).value <= arr.get(i - 1).value) {
				return 0;
			}
		}
		return arr.size();
	}
	
	public static void in(Node head, ArrayList<Node> arr) {
		if (head == null) {
			return;
		}
		in(head.left, arr);
		arr.add(head);
		in(head.right, arr);
	}
	
	public static Node maxSubBSTHead1(Node head) {
		if (head == null) {
			return null;
		}
		if (getBSTSize(head) != 0) {
			return head;
		}
		Node leftAns = maxSubBSTHead1(head.left);
		Node rightAns = maxSubBSTHead1(head.right);
		return getBSTSize(leftAns) >= getBSTSize(rightAns) ? leftAns : rightAns;
	}
	
	public static Node maxSubBSTHead2(Node head) {
		if (head == null) {
			return null;
		}
		return process(head).maxSubBSTHead;
	}
	
}
