package xmht.datastructuresandalgorithms.datastructure.avl;

/**
 * @author shengjk1
 * @date 2020/6/23
 */
public class AvlTreeDemo {
	public static void main(String[] args) {
		int[] arr = {10, 11, 7, 6, 8, 9};
//		int[] arr = {4, 3, 6, 5, 7, 8};
//		int[] arr = {10, 12, 8, 9, 7, 6};
		AVLTree avlTree = new AVLTree();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			avlTree.add(new Node(arr[i]));
		}
		System.out.println("中序遍历");
		avlTree.infixOrder();
		
		System.out.println("在平衡处理~");
		System.out.println("树的高度=" + avlTree.getRoot().height());
		System.out.println("树的左子树的高度=" + avlTree.getRoot().leftHight());
		System.out.println("树的右子树的高度=" + avlTree.getRoot().rightHeight());
		System.out.println("当前的根节点=" + avlTree.getRoot());
		
	}
}

class AVLTree {
	private Node root;
	
	public Node getRoot() {
		return root;
	}
	
	public void add(Node node) {
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}
	
	public void infixOrder() {
		if (root != null) {
			root.infixOrder();
		} else {
			System.out.println("avl tree is empty");
		}
	}
}

class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value) {
		this.value = value;
	}
	
	//返回左子树的高度
	public int leftHight() {
		if (left == null) {
			return 0;
		}
		return left.height();
	}
	
	//返回右子树的高度
	public int rightHeight() {
		if (right == null) {
			return 0;
		}
		return right.height();
	}
	
	//返回以该节点为根节点的树的高度
	public int height() {
		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
	}
	
	//左旋转
	private void leftRotate() {
		//创建新的节点，以当前根节点的值
		Node newNode = new Node(value);
		//把新的节点的左子树设置成当前节点的左子树
		newNode.left = left;
		//把新的节点的右子树设置成当前节点的右子树的左子树
		newNode.right = right.left;
		//把当前节点的值替换为右子节点的值
		value = right.value;
		//把当前节点的右子树设置成当前节点右子树的右子树
		right = right.right;
		//把当前节点的左子树设置成新的节点
		left = newNode;
	}
	
	//右旋转
	private void rightRotate() {
		Node newNode = new Node(value);
		newNode.right = right;
		newNode.left = left.right;
		value = left.value;
		left = left.left;
		right = newNode;
	}
	
	//查找要删除的节点
	public Node search(int value) {
		if (value == this.value) {
			return this;
		} else if (value < this.value) {
			if (this.left == null) {
				return null;
			}
			return this.left.search(value);
		} else {
			if (this.right == null) {
				return null;
			}
			return this.right.search(value);
		}
	}
	
	@Override
	public String toString() {
		return "Node{" +
				"value=" + value +
				'}';
	}
	
	//添加节点
	//满足二叉排序树
	public void add(Node node) {
		if (node == null) {
			return;
		}
		if (node.value < this.value) {
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.add(node);
			}
		} else {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}
		}


////		//左旋转
		if (rightHeight() - leftHight() > 1) {
			//如果它的右子树的左子树的高度大于它的右子树的右子树的高度
			if (right.leftHight() > right.rightHeight()) {
				//先对右子节点进行右旋转
				right.rightRotate();
				//然后对当前节点进行左旋转
				leftRotate();
			} else {
				//直接进行左旋转
				leftRotate();
			}
			return;
		} else if (leftHight() - rightHeight() > 1) {
			int i = leftHight();
			int i1 = rightHeight();
			if (left.rightHeight() > left.leftHight()) {
				int i2 = left.rightHeight();
				int i3 = left.leftHight();
				left.leftRotate();
				rightRotate();
			} else {
				rightRotate();
			}
		}
	}
	
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
}