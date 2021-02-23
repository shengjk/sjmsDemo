package xmht.datastructuresandalgorithms.msb.tree;

/**
 * @author shengjk1
 * @date 2021/2/20
 */
public class LowestAncestor {
	static class Node {
		int  value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	static class Infos {
		Node    ans;
		boolean findO1;
		boolean findO2;

		public Infos(Node ans, boolean findO1, boolean findO2) {
			this.ans = ans;
			this.findO1 = findO1;
			this.findO2 = findO2;
		}
	}

	public static Infos process(Node x, Node node1, Node node2) {
		if (x == null) {
			return new Infos(null, false, false);
		}

		Infos leftInfos = process(x.left, node1, node2);
		Infos rightInfos = process(x.right, node1, node2);

		boolean findO1 = x == node1 || leftInfos.findO1 || rightInfos.findO1;
		boolean findO2 = x == node2 || leftInfos.findO2 || rightInfos.findO2;

		Node ans = leftInfos.ans != null ? leftInfos.ans : null;
		ans = rightInfos.ans != null ? rightInfos.ans : null;

		if (ans == null) {
			if (findO1 && findO2) {
				ans = x;
			}
		}

		return new Infos(ans, findO1, findO2);
	}


}
