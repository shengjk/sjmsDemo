package xmht.datastructuresandalgorithms.datastructure.tree.huffmantree;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author shengjk1
 * @date 2020/6/7
 */
public class HuffmanTree {
	
	public static void main(String[] args) {
		int[] arr = {13, 7, 8, 3, 29, 6, 1};
		Node root = createHuffmanTree(arr);
		preOrder(root);
	}
	
	
	public static void preOrder(Node root) {
		if (root != null) {
			root.preOrder();
		}
	}
	
	
	/**
	 * 1.从小到大进行排序，每个数据都是一个节点，每个节点都可以看成一颗简单的二叉树
	 * 2.取出根节点权值最小的两颗二叉树
	 * 3.组成一颗新的二叉树，该新的二叉树的根节点的权值是前面两颗二叉树根节点权值的和
	 * 4.再将这个新的二叉树以根节点的权值再次排序，不断重复
	 *
	 * @param arr
	 * @return
	 */
	public static Node createHuffmanTree(int[] arr) {
		ArrayList<Node> nodes = new ArrayList<>();
		for (int value : arr) {
			nodes.add(new Node(value));
		}
		
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			
			//取出 根节点 权值最小的两颗二叉树
			//1.取出权值最小的节点
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			
			Node parent = new Node(leftNode.value + rightNode.value);
			parent.left = leftNode;
			parent.right = rightNode;
			
			//从 ArrayList 删除处理过的二叉树
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			
			//将 parent 加入到 nodes
			nodes.add(parent);
		}
		
		return nodes.get(0);
	}
}


//创建节点
class Node implements Comparable<Node> {
	int value; //节点权值
	Node left;
	Node right;
	
	public Node(int value) {
		this.value = value;
	}
	
	
	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		
		if (this.right != null) {
			this.right.preOrder();
		}
	}
	
	@Override
	public String toString() {
		return "Node[" +
				"value=" + value +
				']';
	}
	
	@Override
	public int compareTo(@NotNull Node o) {
		//从小到大排
		return this.value - o.value;
	}
}