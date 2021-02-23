package xmht.datastructuresandalgorithms.msb.tree;

/**
 * @author shengjk1
 * @date 2021/2/20
 */
public class MaxDistance {

	static class Node {
		int  value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	static class Infos {
		int maxDistance;
		int height;

		public Infos(int maxDistance, int height) {
			this.maxDistance = maxDistance;
			this.height = height;
		}
	}

	public static Infos process(Node x) {
		if (x == null) {
			return new Infos(0, 0);
		}

		Infos leftInfos = process(x.left);
		Infos rightInfos = process(x.right);

		int height = Math.max(leftInfos.height, rightInfos.height) + 1;

		int maxDistance = Math.max(leftInfos.height + rightInfos.height + 1, Math.max(rightInfos.maxDistance, leftInfos.maxDistance));

		return new Infos(maxDistance, height);
	}
}
