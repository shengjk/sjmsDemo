package xmht.zsda.handwriting.seven;

/**
 * @author shengjk1
 * @date 2020/10/30
 */
public class RecursiveTraversalBT {
	//前序遍历
	//头左右
	public static void pre(Node head) {
		if (head == null) {
			return;
		}
		System.out.println(head);
		pre(head.left);
		pre(head.rihgt);
	}
	
	//左头右
	public static void in(Node head) {
		if (head == null) {
			return;
		}
		in(head.left);
		System.out.println(head);
		in(head.rihgt);
	}
	
	//左右头
	public static void pos(Node head) {
		if (head == null) {
			return;
		}
		pos(head.left);
		pos(head.rihgt);
		System.out.println(head);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.rihgt = new Node(3);
		root.left.left = new Node(4);
		root.left.rihgt = new Node(5);
		root.rihgt.left = new Node(6);
		root.rihgt.rihgt = new Node(7);
		
		System.out.println("====pre====");
		pre(root);
		System.out.println("====in====");
		in(root);
		System.out.println("====pos====");
		pos(root);
	}
	
	public static class Node {
		int val;
		Node left;
		Node rihgt;
		
		public Node(int val) {
			this.val = val;
		}
		
		@Override
		public String toString() {
			return "Node{" +
					"val=" + val +
					'}';
		}
	}
}
