package xmht.datastructuresandalgorithms.datastructure.tree.huffmancode;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author shengjk1
 * @date 2020/6/7
 */
public class HuffManCode {
	//生成huffman 编码
	static Map<Byte, String> huffmanCodes = new HashMap<>();
	static StringBuilder stringBuilder = new StringBuilder();
	
	public static void main(String[] args) {
		String str = "i like like like java do you like a java";
		byte[] contentBytes = str.getBytes();
		System.out.println(contentBytes.length);
		List<Node> nodes = getNodes(contentBytes);
		System.out.println(nodes);
		
		Node root = createHuffmanTree(nodes);
		root.preOrder();
		
		getCodes(root);
		//{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
		System.out.println(huffmanCodes);
		
		System.out.println();
		
	}
	
	//
	
	/**
	 * 将字节数组转化为node
	 *
	 * @param bytes
	 * @return
	 */
	private static List<Node> getNodes(byte[] bytes) {
		ArrayList<Node> nodes = new ArrayList<>();
		
		HashMap<Byte, Integer> counts = new HashMap<>();
		for (byte aByte : bytes) {
			Integer count = counts.get(aByte);
			if (count == null) {
				counts.put(aByte, 1);
			} else {
				counts.put(aByte, count + 1);
			}
		}
		
		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}
	
	private static Node createHuffmanTree(List<Node> nodes) {
		
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			
			//没有 data 只有权值.
			//只有叶子节点才既有 data 又有权值
			Node parent = new Node(null, leftNode.weight + rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	
	
	private static void getCodes(Node node) {
		if (node == null) {
			return;
		}
		getCodes(node.left, "0", stringBuilder);
		getCodes(node.right, "1", stringBuilder);
	}
	
	/**
	 * @param node
	 * @param code
	 * @param stringBuilder
	 */
	private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
		StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
		//将 code 加入到 stringBuilder2
		stringBuilder1.append(code);
		if (node != null) {
			//判断当前 node 是叶子节点还是非叶子节点
			if (node.data == null) {
				//向左递归
				getCodes(node.left, "0", stringBuilder1);
				//向右递归
				getCodes(node.right, "1", stringBuilder1);
			} else {
				huffmanCodes.put(node.data, stringBuilder1.toString());
			}
		}
	}
	
	
	private static void preOrder(Node root) {
		if (root != null) {
			root.preOrder();
		}
	}
}


//
class Node implements Comparable<Node> {
	Byte data; //存储数据(字符)本身
	int weight;//权值，表示字符出现的次数
	Node left;
	Node right;
	
	public Node(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "Node[" +
				"data=" + data +
				", weight=" + weight +
				']';
	}
	
	@Override
	public int compareTo(@NotNull Node o) {
		return this.weight - o.weight;
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
}
