package xmht.datastructuresandalgorithms.msb.tree;

/**
 * @author shengjk1
 * @date 2021/2/20
 */
public class IsBalance {

	static class Node {
		int  value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	static class Infos {
		boolean isBalaced;
		int     height;

		public Infos(boolean isBalaced, int height) {
			this.isBalaced = isBalaced;
			this.height = height;
		}
	}

	public static Infos process2(Node x) {
		if (x == null) {
			return new Infos(true, 0);
		}

		Infos leftInfos = process2(x.left);
		Infos rightInfos = process2(x.right);

		boolean isBalance = (leftInfos.isBalaced && rightInfos.isBalaced && Math.abs(leftInfos.height - rightInfos.height) < 2);
		int height = Math.max(leftInfos.height, rightInfos.height) + 1;

		return new Infos(isBalance, height);
	}


	public static boolean isBalanced2(Node head) {
		return process2(head).isBalaced;
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
			}
		}
		System.out.println("finish!");
	}

}
