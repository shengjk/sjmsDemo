package xmht.datastructuresandalgorithms.msb.tree;

/**
 * @author shengjk1
 * @date 2021/2/20
 */
public class IsCBT {
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
		boolean isCBT;
		int     height;

		public Infos(boolean isFull, boolean isCBT, int height) {
			this.isFull = isFull;
			this.isCBT = isCBT;
			this.height = height;
		}
	}


	public static Infos process(Node x) {
		if (x == null) {
			return new Infos(true, true, 0);
		}

		Infos leftInfos = process(x.left);
		Infos rightInfos = process(x.right);

		int height = Math.max(leftInfos.height, rightInfos.height) + 1;
		boolean isFull = leftInfos.isFull && rightInfos.isFull && leftInfos.height == rightInfos.height;

		boolean isCBT = false;
		if (isFull) {
			isCBT = true;
		} else {
			if (leftInfos.isCBT && rightInfos.isCBT) {
				if (leftInfos.isCBT && rightInfos.isFull && leftInfos.height == rightInfos.height + 1) {
					isCBT = true;
				}
				if (leftInfos.isFull && rightInfos.isFull && leftInfos.height == rightInfos.height + 1) {
					isCBT = true;
				}
				if (leftInfos.isFull && rightInfos.isCBT && leftInfos.height == rightInfos.height) {
					isCBT = true;
				}
			}
		}
		return new Infos(isFull, isCBT, height);
	}
}
