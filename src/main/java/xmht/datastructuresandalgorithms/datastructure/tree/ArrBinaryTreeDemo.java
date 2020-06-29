package xmht.datastructuresandalgorithms.datastructure.tree;

/**
 * @author shengjk1
 * @date 2020/5/30
 */
public class ArrBinaryTreeDemo {
	public static void main(String[] args) {
		//用数组去实现二叉树
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
		arrBinaryTree.preOrder();
	}
}

class ArrBinaryTree {
	// 存储数据节点的数据
	private int[] arr;
	
	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	public void preOrder() {
		this.preOrder(0);
	}
	
	public void preOrder(int index) {
		//如果数组为空或者 arr.length==0
		if (arr == null || arr.length == 0) {
			return;
		}
		//输出当前这个元素
		System.out.println(arr[index]);
		
		if ((2 * index + 1) < arr.length) {
			preOrder(2 * index + 1);
		}
		
		if ((2 * index + 2) < arr.length) {
			preOrder(2 * index + 2);
		}
	}
}