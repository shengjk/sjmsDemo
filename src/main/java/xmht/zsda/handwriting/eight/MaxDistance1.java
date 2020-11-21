package xmht.zsda.handwriting.eight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author shengjk1
 * @date 2020/11/19
 */
/*
 x 参与    树的最大高度
 x 不参与   max{左树的最大距离，右树的最大距离}
 
最大距离 左右树的高度之和+1 与 最大距离的最大值，因为它要的就是最大距离

 */
public class MaxDistance1 {
	public static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static class Info {
		int height;
		int maxDistance;
		
		public Info(int height, int maxDistance) {
			this.height = height;
			this.maxDistance = maxDistance;
		}
	}
	
	public static Info process(Node x) {
		if (x == null) {
			return new Info(0, 0);
		}
		Info leftInfo = process(x.left);
		Info rightInfo = process(x.right);
		
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		//最大距离 左右树的高度之和+1 与 最大距离的最大值，因为它要的就是最大距离
		int maxDistance = Math.max(
				leftInfo.height + rightInfo.height + 1,
				Math.max(leftInfo.maxDistance, rightInfo.maxDistance));
		
		return new Info(height, maxDistance);
	}
	
	public static int maxDistance1(Node head) {
		if (head == null) {
			return 0;
		}
		ArrayList<Node> arr = getPrelist(head);
		HashMap<Node, Node> parentMap = getParentMap(head);
		int max = 0;
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i; j < arr.size(); j++) {
				max = Math.max(max, distance(parentMap, arr.get(i), arr.get(j)));
			}
		}
		return max;
	}
	
	public static ArrayList<Node> getPrelist(Node head) {
		ArrayList<Node> arr = new ArrayList<>();
		fillPrelist(head, arr);
		return arr;
	}
	
	public static void fillPrelist(Node head, ArrayList<Node> arr) {
		if (head == null) {
			return;
		}
		arr.add(head);
		fillPrelist(head.left, arr);
		fillPrelist(head.right, arr);
	}
	
	public static HashMap<Node, Node> getParentMap(Node head) {
		HashMap<Node, Node> map = new HashMap<>();
		map.put(head, null);
		fillParentMap(head, map);
		return map;
	}
	
	public static void fillParentMap(Node head, HashMap<Node, Node> parentMap) {
		if (head.left != null) {
			parentMap.put(head.left, head);
			fillParentMap(head.left, parentMap);
		}
		if (head.right != null) {
			parentMap.put(head.right, head);
			fillParentMap(head.right, parentMap);
		}
	}
	
	public static int distance(HashMap<Node, Node> parentMap, Node o1, Node o2) {
		HashSet<Node> o1Set = new HashSet<>();
		Node cur = o1;
		o1Set.add(cur);
		while (parentMap.get(cur) != null) {
			cur = parentMap.get(cur);
			o1Set.add(cur);
		}
		cur = o2;
		while (!o1Set.contains(cur)) {
			cur = parentMap.get(cur);
		}
		Node lowestAncestor = cur;
		cur = o1;
		int distance1 = 1;
		while (cur != lowestAncestor) {
			cur = parentMap.get(cur);
			distance1++;
		}
		cur = o2;
		int distance2 = 1;
		while (cur != lowestAncestor) {
			cur = parentMap.get(cur);
			distance2++;
		}
		return distance1 + distance2 - 1;
	}
	
	// for test
	public static Node generateRandomBST(int maxLevel, int maxValue) {
		return generate(1, maxLevel, maxValue);
	}
	
	// for test
	public static Node generate(int level, int maxLevel, int maxValue) {
		if (level > maxLevel || Math.random() < 0.5) {
			return null;
		}
		Node head = new Node((int) (Math.random() * maxValue));
		head.left = generate(level + 1, maxLevel, maxValue);
		head.right = generate(level + 1, maxLevel, maxValue);
		return head;
	}
	
	public static int maxDistance2(Node head) {
//		System.out.println("maxDistance:" + process.maxDistance + " height:" + process.height);
		return process(head).maxDistance;
	}
	
	public static void main(String[] args) {
		int maxLevel = 4;
		int maxValue = 100;
		int testTimes = 1000000;
		for (int i = 0; i < testTimes; i++) {
			Node head = generateRandomBST(maxLevel, maxValue);
			if (maxDistance1(head) != maxDistance2(head)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("finish!");
	}
}
