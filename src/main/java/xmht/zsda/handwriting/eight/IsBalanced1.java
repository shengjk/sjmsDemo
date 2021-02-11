package xmht.zsda.handwriting.eight;

/**
 * @author shengjk1
 * @date 2020/11/19
 */
/*
是否为平衡二叉树    左树和右树的高度差不大于1
1. isBalanced
2. height

isBalanced 是不是平衡二叉树要求非
 */
public class IsBalanced1 {
	public static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	public static class Info {
		boolean isBalanced;
		int height;

		public Info(boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}

	public static Info process(Node x) {
		if (x == null) {
			return new Info(true, 0);
		}

		Info leftInfo = process(x.left);
		Info rightInfo = process(x.right);

		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		//isBalanced 是不是平衡二叉树要求非
		boolean isBalanced = true;
		if (!leftInfo.isBalanced
				|| !rightInfo.isBalanced
				|| Math.abs(leftInfo.height - rightInfo.height) > 1) {
			isBalanced = false;
		}
		return new Info(isBalanced, height);
	}

	public static boolean isBalanced2(Node head) {
		if (head == null) {
			return true;
		}
		return process(head).isBalanced;
	}

	public static boolean isBalanced1(Node head) {
		boolean[] ans = new boolean[1];
		ans[0] = true;
		process1(head, ans);
		return ans[0];
	}

	public static int process1(Node head, boolean[] ans) {
		if (!ans[0] || head == null) {
			return -1;
		}
		int leftHeight = process1(head.left, ans);
		int rightHeight = process1(head.right, ans);
		if (Math.abs(leftHeight - rightHeight) > 1) {
			ans[0] = false;
		}
		return Math.max(leftHeight, rightHeight) + 1;
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
		int maxLevel = 5;
		int maxValue = 100;
		int testTimes = 1000000;
		for (int i = 0; i < testTimes; i++) {
			Node head = generateRandomBST(maxLevel, maxValue);
			if (isBalanced1(head) != isBalanced2(head)) {
				System.out.println("Oops!");
				return;
			}
		}
		System.out.println("finish!");
	}
}