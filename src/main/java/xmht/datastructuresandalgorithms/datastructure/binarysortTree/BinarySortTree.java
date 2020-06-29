package xmht.datastructuresandalgorithms.datastructure.binarysortTree;

/**
 * @author shengjk1
 * @date 2020/6/15
 */
public class BinarySortTree {
	public static void main(String[] args) {
		int[] arr = {7, 3, 10, 12, 5, -1, 9};
		BinarySortTree1 binarySortTree = new BinarySortTree1();
		for (int i : arr) {
			binarySortTree.add(new Node(i));
		}
		
		System.out.println("中序遍历二叉树");
		binarySortTree.infixOrder();
		
		binarySortTree.delNode(3);
		
		System.out.println("删除之后====中序遍历二叉树");
		binarySortTree.infixOrder();
	}
}

class BinarySortTree1 {
	//
	private Node root;
	
	public void add(Node node) {
		if (this.root != null) {
			this.root.add(node);
		} else {
			root = node;
		}
	}
	
	//查找节点
	public Node search(int value) {
		if (root == null) {
			return null;
		} else {
			return root.search(value);
		}
	}
	
	//查找父节点
	public Node searchParent(int value) {
		if (root == null) {
			return null;
		} else {
			return root.searchParent(value);
		}
	}
	
	/**
	 * 返回以 node 为根节点的二叉排序树的最小节点的值
	 * 并删除以 node 为根节点的二叉排序树的最小节点
	 *
	 * @param node 传入节点
	 * @return 以 node 为根节点的二叉排序树的最小节点的值
	 */
	public int delRightTreeMin(Node node) {
		Node target = node;
		while (target.left != null) {
			target = target.left;
		}
		delNode(target.value);
		return target.value;
		
	}
	
	//删除节点
	public void delNode(int value) {
		if (root == null) {
			return;
		} else {
			//1.先找到要删除节点 targetNode
			Node targetNode = root.search(value);
			if (targetNode == null) {
				return;
			}
			//如果发现当前的二叉树只有一个节点
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			
			//找到 targetNode 的 parentnode
			Node parentNode = searchParent(value);
			
			//1.如果删除的节点是叶子节点
			if (targetNode.right == null && targetNode.left == null) {
				if (parentNode.left != null && parentNode.left.value == value) {
					parentNode.left = null;
				} else {
					parentNode.right = null;
				}
				//删除有两颗子树的节点
			} else if (targetNode.left != null && targetNode.right != null) {
				int minVal = delRightTreeMin(targetNode.right);
				targetNode.value = minVal;
				//删除只有一颗子树的节点
			} else {
				//如果删除的节点只有左子树
				if (targetNode.left != null) {
					if (parentNode != null) {
						if (parentNode.left.value == value) {
							parentNode.left = targetNode.left;
							//targetNode 为 parent 的右节点
						} else {
							parentNode.right = targetNode.left;
						}
					} else {
						root = targetNode.left;
					}
				} else {
					if (parentNode != null) {
						if (parentNode.left.value == value) {
							parentNode.left = targetNode.right;
						} else {
							parentNode.right = targetNode.right;
						}
					} else {
						root = targetNode.right;
					}
				}
			}
		}
	}
	
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		}
	}
	
	@Override
	public String toString() {
		return "BinarySortTree1{" +
				"root=" + root +
				'}';
	}
}

class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value) {
		this.value = value;
	}
	
	
	/**
	 * @param value 希望删除节点的值
	 * @return 有则返回否则返回null
	 */
	public Node search(int value) {
		if (value == this.value) {
			return this;
			//向左子树查找
		} else if (value < this.value) {
			if (this.left == null) {
				return null;
			}
			return this.left.search(value);
			
			//向右子树查找
		} else {
			if (this.right == null) {
				return null;
			}
			return this.right.search(value);
		}
	}
	
	//查找要删除节点的父节点
	
	/**
	 * @param value
	 * @return
	 */
	public Node searchParent(int value) {
		//如果当前节点就是要删除节点的父节点，就返回
		if ((this.left != null && this.left.value == value) ||
				(this.right != null && this.right.value == value)) {
			return this;
		} else {
			if (value < this.value && this.left != null) {
				return this.left.searchParent(value);
			} else if (value >= this.value && this.right != null) {
				return this.right.searchParent(value);
			} else {
				return null;
			}
		}
	}
	
	//添加节点
	//递归的形式添加，需要满足二叉排序树的要求
	public void add(Node node) {
		if (node == null) {
			return;
		}
		//判断传入节点的值，和当前子树的根节点的值的关系
		if (node.value < this.value) {
			if (this.left == null) {
				this.left = node;
			} else {
				//递归的向左子树添加
				this.left.add(node);
			}
		} else {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}
		}
	}
	
	//中序遍历
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	
	
	@Override
	public String toString() {
		return "Node{" +
				"value=" + value +
				'}';
	}
}