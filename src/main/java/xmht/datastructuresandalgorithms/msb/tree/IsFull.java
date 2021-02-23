package xmht.datastructuresandalgorithms.msb.tree;

/**
 * @author shengjk1
 * @date 2021/2/20
 */
public class IsFull {
	static class Node {
		int  value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	static class Infos {
		boolean isFull;
		int     height;
		int     size;

		public Infos(boolean isFull, int height, int size) {
			this.isFull = isFull;
			this.height = height;
			this.size = size;
		}
	}

	public static Infos process(Node x) {
		if (x == null) {
			return new Infos(true, 0, 0);
		}

		Infos leftInfos = process(x.left);
		Infos rightInfos = process(x.right);

		int height = Math.max(leftInfos.height, rightInfos.height) + 1;
		int size = leftInfos.size + rightInfos.size + 1;

		boolean isFull = (leftInfos.isFull && rightInfos.isFull && (1 << height) == size + 1);

		return new Infos(isFull, height, size);
	}

	public static boolean isFull2(Node head) {
		if (head == null) {
			return true;
		}
		Infos all = process(head);
		return all.isFull;
	}


	public static boolean isFull1(Node head) {
		if (head == null) {
			return true;
		}
		int height = h(head);
		int nodes = n(head);
		return (1 << height) - 1 == nodes;
	}

	public static int h(Node head) {
		if (head == null) {
			return 0;
		}
		return Math.max(h(head.left), h(head.right)) + 1;
	}

	public static int n(Node head) {
		if (head == null) {
			return 0;
		}
		return n(head.left) + n(head.right) + 1;
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
			if (isFull1(head) != isFull2(head)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("finish!");
	}

}
