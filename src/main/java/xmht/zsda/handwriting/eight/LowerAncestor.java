package xmht.zsda.handwriting.eight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author shengjk1
 * @date 2020/11/11
 */
public class LowerAncestor {
	
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
	
	// for test
	public static Node pickRandomOne(Node head) {
		if (head == null) {
			return null;
		}
		ArrayList<Node> arr = new ArrayList<>();
		fillPrelist(head, arr);
		int randomIndex = (int) (Math.random() * arr.size());
		return arr.get(randomIndex);
	}
	
	// for test
	public static void fillPrelist(Node head, ArrayList<Node> arr) {
		if (head == null) {
			return;
		}
		arr.add(head);
		fillPrelist(head.left, arr);
		fillPrelist(head.right, arr);
	}
	
	public static void main(String[] args) {
		int maxLevel = 4;
		int maxValue = 100;
		int testTimes = 1000000;
		for (int i = 0; i < testTimes; i++) {
			Node head = generateRandomBST(maxLevel, maxValue);
			Node o1 = pickRandomOne(head);
			Node o2 = pickRandomOne(head);
			if (lowestAncestor1(head, o1, o2) != lowestAncestor2(head, o1, o2)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("finish!");
	}
	
	public static Node lowestAncestor1(Node head, Node o1, Node o2) {
		if (head == null) {
			return null;
		}
		// key的父节点是value
		HashMap<Node, Node> parentMap = new HashMap<>();
		parentMap.put(head, null);
		fillParentMap(head, parentMap);
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
		return cur;
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
	
	public static Node lowestAncestor2(Node head, Node o1, Node o2) {
		return process(head, o1, o2).ans;
	}
	
	public static Infos process(Node x, Node o1, Node o2) {
		if (x == null) {
			return new Infos(null, false, false);
		}
		Infos leftInfos = process(x.left, o1, o2);
		Infos rightInfos = process(x.right, o1, o2);
		
		boolean findO1 = x == o1 || leftInfos.findO1 || rightInfos.findO1;
		boolean findO2 = x == o2 || leftInfos.findO2 || rightInfos.findO2;
		
		Node ans = null;
		if (leftInfos.ans != null) {
			ans = leftInfos.ans;
		}
		if (rightInfos.ans != null) {
			ans = rightInfos.ans;
		}
		
		if (ans == null) {
			if (findO1 && findO2) {
				ans = x;
			}
		}
		return new Infos(ans, findO1, findO2);
	}
	
	public static class Infos {
		Node ans;
		boolean findO1;
		boolean findO2;
		
		public Infos(Node ans, boolean findO1, boolean findO2) {
			this.ans = ans;
			this.findO1 = findO1;
			this.findO2 = findO2;
		}
	}
	
	public static class Node {
		int val;
		Node left;
		Node right;
		
		public Node(int val) {
			this.val = val;
		}
	}
	
}
