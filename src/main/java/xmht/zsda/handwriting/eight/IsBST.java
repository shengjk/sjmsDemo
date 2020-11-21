package xmht.zsda.handwriting.eight;

/**
 * @author shengjk1
 * @date 2020/11/18
 */
/*
搜索二叉树
左树上的所有节点都小于它的根节点，右树上的所有节点都大于的它的根节点

1. 是不是搜索二叉树
2. 左树的最大值小于根节点，右树上的最小值大于根节点
 */
public class IsBST {
	public static boolean isBST(Node head) {
		if (head == null) {
			return true;
		}
		return process(head).isBST;
	}
	
	public static Info process(Node x) {
		if (x == null) {
			return null;
		}
		
		Info leftInfo = process(x.left);
		Info rightInfo = process(x.rihght);
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
		
		boolean isBST = false;
		if ((leftInfo == null ? true : (leftInfo.isBST && leftInfo.max < x.value))
				&& (rightInfo == null ? true : (rightInfo.isBST && rightInfo.min > x.value))) {
			isBST = true;
		}
		return new Info(isBST, min, max);
	}
	
	public static class Node {
		int value;
		Node left;
		Node rihght;
		
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
}
