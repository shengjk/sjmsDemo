package xmht.zsda.handwriting.eight;

import java.util.ArrayList;

/**
 * @author shengjk1
 * @date 2020/11/19
 */
/*
是否是搜索二叉树  左树的最大值小于 head.value 右树最小值大于 head.value
1. isBST
2. min
3. max
 */
public class IsBST1 {
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
		int min;
		int max;
		
		public Info(boolean isBST, int min, int max) {
			this.isBST = isBST;
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
		if (leftInfo != null) {
			min = Math.min(min, leftInfo.min);
			max = Math.max(max, leftInfo.max);
		}
		if (rightInfo != null) {
			min = Math.min(min, rightInfo.min);
			max = Math.max(max, rightInfo.max);
		}
		
		boolean isBST = (leftInfo == null ? true : (leftInfo.isBST && leftInfo.max < x.value)) &&
				(rightInfo == null ? true : (rightInfo.isBST && rightInfo.min > x.value));
		return new Info(isBST, min, max);
	}
	
	public static boolean isBST1(Node head) {
		if (head == null) {
			return true;
		}
		ArrayList<Node> arr = new ArrayList<>();
		in(head, arr);
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i).value <= arr.get(i - 1).value) {
				return false;
			}
		}
		return true;
	}
	
	public static void in(Node head, ArrayList<Node> arr) {
		if (head == null) {
			return;
		}
		in(head.left, arr);
		arr.add(head);
		in(head.right, arr);
	}
	
	public static boolean isBST2(Node head) {
		if (head == null) {
			return true;
		}
		return process(head).isBST;
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
			if (isBST1(head) != isBST2(head)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("finish!");
	}
	
}
