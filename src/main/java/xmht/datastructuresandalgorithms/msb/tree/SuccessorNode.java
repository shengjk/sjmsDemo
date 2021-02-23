package xmht.datastructuresandalgorithms.msb.tree;

/**
 * @author shengjk1
 * @date 2021/2/19
 */
//去除为 null 的基本判断
public class SuccessorNode {
	static class Node {
		int  value;
		Node left;
		Node right;
		Node parent;

		public Node(int value) {
			this.value = value;
		}
	}

	public static Node getSuccessorNode(Node node) {

		//有右子树，则右子树的最左节点
		if (node.right != null) {
			Node node1 = node.right;
			while (node1.left != null) {
				node1 = node1.left;
			}
			return node1;
		} else {
			//没有右子树，我是我父节点的字节点，这个父是后继
			Node parent = node.parent;
			while (parent != null && parent.left != node) {
				node = parent;
				parent = parent.parent;
			}
			return parent;
		}
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

}
