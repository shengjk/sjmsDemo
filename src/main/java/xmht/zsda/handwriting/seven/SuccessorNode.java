package xmht.zsda.handwriting.seven;

/**
 * @author shengjk1
 * @date 2020/10/27
 */
public class SuccessorNode {
	//得到后续节点，如果有右节点，后续节点就是右节点的最左节点
	public static Node getSuccessorNode(Node node) {
		if (node.right != null) {
			return getLeftMost(node);
		} else {
			//无右子树，则当前节点父节点饿左等于当前节点
			Node parent = node.parent;
			while (parent != null && parent.right == node) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	
	public static Node getLeftMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	
	//给定一个节点，求这个节点的前驱
	public static Node Precursor(Node node) {
		if (node.left != null) {
			return getRightMost(node);
		} else {
			Node parent = node.parent;
			while (parent != null && parent.left == node) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	
	public static Node getRightMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}
	
	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;
		
		Node test = head.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + getSuccessorNode(test));
	}
	
	public static class Node {
		int value;
		Node left;
		Node right;
		Node parent;
		
		public Node(int value) {
			this.value = value;
		}
	}
}
