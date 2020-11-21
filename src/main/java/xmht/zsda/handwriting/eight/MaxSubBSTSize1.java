package xmht.zsda.handwriting.eight;

import java.util.ArrayList;

/**
 * @author shengjk1
 * @date 2020/11/19
 */
/*
给定一棵二叉树的头节点head，
返回这颗二叉树中最大的二叉搜索子树的大小

首先需要判断是二叉搜索树，maxSize( nodes )

涉及到最大值最小值的都返回 null，因为没有办法确定最小值或者最大值的具体值
 */
public class MaxSubBSTSize1 {
	public static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static class Info {
		boolean isBST;
		int maxSubBSTSize;
		int min;
		int max;
		
		public Info(boolean isBST, int maxSubBSTSize, int min, int max) {
			this.isBST = isBST;
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
		
		int min = x.value;
		int max = x.value;
		int maxSubBSTSize = 0;
		if (leftInfo != null) {
			min = Math.min(leftInfo.min, min);
			max = Math.max(max, leftInfo.max);
			maxSubBSTSize = Math.max(maxSubBSTSize, leftInfo.maxSubBSTSize);
		}
		if (rightInfo != null) {
			min = Math.min(min, rightInfo.min);
			max = Math.max(max, rightInfo.max);
			maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
		}
		
		boolean isBST = false;
		if ((leftInfo == null ? true : (leftInfo.isBST && leftInfo.max < x.value))
				&& (rightInfo == null ? true : (rightInfo.isBST && rightInfo.min > x.value))) {
			isBST = true;
			// maxSubBSTSize
			maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize) +
					(rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
		}
		return new Info(isBST, maxSubBSTSize, min, max);
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
	
	public static int maxSubBSTSize1(Node head) {
		if (head == null) {
			return 0;
		}
		int h = getBSTSize(head);
		if (h != 0) {
			return h;
		}
		return Math.max(maxSubBSTSize1(head.left), maxSubBSTSize1(head.right));
	}
	
	public static int maxSubBSTSize2(Node head) {
		if (head == null) {
			return 0;
		}
		return process(head).maxSubBSTSize;
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
			if (maxSubBSTSize1(head) != maxSubBSTSize2(head)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("finish!");
	}
	
}
