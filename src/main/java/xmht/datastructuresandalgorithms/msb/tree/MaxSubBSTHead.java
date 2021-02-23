package xmht.datastructuresandalgorithms.msb.tree;

import java.util.ArrayList;

/**
 * @author shengjk1
 * @date 2021/2/20
 */
public class MaxSubBSTHead {
	static class Node {
		int  value;
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

	static class Infos {
		int     maxSubBSTSize;
		boolean isBST;
		int     max;
		int     min;
		Node    maxSubBSTHead;

		public Infos(int maxSubBSTSize, boolean isBST, int max, int min, Node maxSubBSTHead) {
			this.maxSubBSTSize = maxSubBSTSize;
			this.isBST = isBST;
			this.max = max;
			this.min = min;
			this.maxSubBSTHead = maxSubBSTHead;
		}
	}

	public static Infos process(Node x) {
		if (x == null) {
			return null;
		}

		Infos leftInfos = process(x.left);
		Infos rightInfos = process(x.right);

		int max = x.value;
		int min = x.value;

		if (leftInfos != null) {
			max = Math.max(leftInfos.max, max);
			min = Math.min(leftInfos.min, min);
		}

		if (rightInfos != null) {
			max = Math.max(rightInfos.max, max);
			min = Math.min(rightInfos.min, min);
		}

		Node maxSubBSTHead = null;
		if (leftInfos != null) {
			maxSubBSTHead = leftInfos.maxSubBSTHead;
		}
		if (rightInfos != null) {
			if (rightInfos.maxSubBSTSize > (leftInfos == null ? 0 : leftInfos.maxSubBSTSize)) {
				maxSubBSTHead = rightInfos.maxSubBSTHead;
			}
		}

		boolean isBST = ((leftInfos == null ? true : (leftInfos.isBST && leftInfos.max < x.value)) && (rightInfos == null ? true : (rightInfos.isBST && rightInfos.min > x.value)));

		int maxSubBSTSize = isBST ? ((leftInfos == null ? 0 : leftInfos.maxSubBSTSize) + (rightInfos == null ? 0 : rightInfos.maxSubBSTSize) + 1) :
				Math.max((leftInfos == null ? 0 : leftInfos.maxSubBSTSize), (rightInfos == null ? 0 : rightInfos.maxSubBSTSize));


		Node head = isBST ? x : maxSubBSTHead;

		return new Infos(maxSubBSTSize, isBST, max, min, head);

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
				System.out.println("maxSubBSTHead1(head) = " + maxSubBSTHead1(head));
				System.out.println("maxSubBSTHead2(head) = " + maxSubBSTHead2(head));
				System.out.println("Oops!");
			}
		}
		System.out.println("finish!");
	}

}
