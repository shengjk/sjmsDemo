package xmht.zsda.handwriting.eight;

/**
 * @author shengjk1
 * @date 2020/11/18
 */
/*
满二叉树  2^height -1 =nodes

拆分到最细
1. 左树是满二叉树  heigh,nodes
2. 右树是满二叉树  height,nodes
 */
public class IsFull {
	public static boolean isFull(Node x) {
		if (x == null) {
			return true;
		}
		Info infos = process(x);
		return (1 << infos.height) == infos.nodes;
	}
	
	public static Info process(Node x) {
		if (x == null) {
			return new Info(0, 0);
		}
		Info leftInfos = process(x.left);
		Info rightInfos = process(x.right);
		
		int height = Math.max(leftInfos.height, rightInfos.height) + 1;
		int nodes = leftInfos.nodes + rightInfos.nodes + 1;
		
		return new Info(height, nodes);
	}
	
	public static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static class Info {
		int height;
		int nodes;
		
		public Info(int height, int nodes) {
			this.height = height;
			this.nodes = nodes;
		}
	}
}
