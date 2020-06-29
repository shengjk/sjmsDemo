package xmht.datastructuresandalgorithms.datastructure.tree.threaded;

/**
 * @author shengjk1
 * @date 2020/5/31
 */
public class ThreadedBinaryTree {
}

// 实现了 线索化功能的二叉树
class BinaryTree {
	private HeroNode root;
	
	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	//删除节点
	public void delNode(int no) {
		if (root != null) {
			if (root.getNo() == no) {
				root = null;
			} else {
				root.delNo(no);
			}
		}
	}
	
	//前序遍历
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		}
	}
	
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		}
	}
	
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		}
	}
	
	//前序查找
	public HeroNode preOrderSearch(int no) {
		if (root != null) {
			return root.preOrderSearch(no);
		} else {
			return null;
		}
	}
	
	public HeroNode infixOrderSearch(int no) {
		if (root != null) {
			return root.infixOrderSearch(no);
		} else {
			return null;
		}
	}
	
	public HeroNode postOrderSearch(int no) {
		if (root != null) {
			return root.postOrderSearch(no);
		} else {
			return null;
		}
	}
	
}


class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	
	public HeroNode(int no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public HeroNode getLeft() {
		return left;
	}
	
	public void setLeft(HeroNode left) {
		this.left = left;
	}
	
	public HeroNode getRight() {
		return right;
	}
	
	public void setRight(HeroNode right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "HearNode{" +
				"no=" + no +
				", name='" + name + '\'' +
				'}';
	}
	
	/*
	1.如果是叶子节点则删除该节点
	2.如果是非叶子节点则删除子树
	 */
	public void delNo(int no) {
		if (this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		
		if (this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		
		if (this.left != null) {
			this.left.delNo(no);
		}
		
		if (this.right != null) {
			this.right.delNo(no);
		}
	}
	
	//前序遍历
	public void preOrder() {
		System.out.println(this);
		
		if (this.left != null) {
			this.left.preOrder();
		}
		
		if (this.right != null) {
			this.right.preOrder();
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
	
	//后序遍历
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
	
	
	//前序查找
	public HeroNode preOrderSearch(int no) {
		if (this.no == no) {
			return this;
		}
		
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.preOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		
		/*
		1.左递归前序查找，找到节点就返回，否则继续判断
		2. 当前节点的右子节点是否为空如果不为空则继续
		 */
		if (this.right != null) {
			resNode = this.right.preOrderSearch(no);
		}
		return resNode;
	}
	
	//中序查找
	public HeroNode infixOrderSearch(int no) {
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.preOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		
		if (this.no == no) {
			return this;
		}
		
		if (this.right != null) {
			resNode = this.right.preOrderSearch(no);
		}
		return resNode;
	}
	
	//后序查找
	public HeroNode postOrderSearch(int no) {
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.preOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		
		if (this.right != null) {
			resNode = this.right.preOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		
		if (this.no == no) {
			return this;
		}
		return resNode;
	}
}