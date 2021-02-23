package xmht.datastructuresandalgorithms.msb.tree;

import java.util.ArrayList;

/**
 * @author shengjk1
 * @date 2021/2/20
 */
public class MaxSubBSTSize {
	static class Node {
		int  value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	static class Infos {
		int     maxSubBSTSize;
		boolean isBST;
		int     max;
		int     min;

		public Infos(int maxSubBSTSize, boolean isBST, int max, int min) {
			this.maxSubBSTSize = maxSubBSTSize;
			this.isBST = isBST;
			this.max = max;
			this.min = min;
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

		boolean isBST = ((leftInfos == null ? true : (leftInfos.isBST && leftInfos.max < x.value)) && (rightInfos == null ? true : (rightInfos.isBST && rightInfos.min > x.value)));

		int size = isBST ? ((leftInfos == null ? 0 : leftInfos.maxSubBSTSize) + (rightInfos == null ? 0 : rightInfos.maxSubBSTSize) + 1) :
				Math.max((leftInfos == null ? 0 : leftInfos.maxSubBSTSize), (rightInfos == null ? 0 : rightInfos.maxSubBSTSize));

		return new Infos(size, isBST, max, min);

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
