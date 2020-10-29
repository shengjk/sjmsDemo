package xmht.zsda.handwriting.seven;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shengjk1
 * @date 2020/10/23
 */
public class SerializeAndReconstructTree {
	
	//前序
	public static Queue<String> preSerial(Node head) {
		Queue<String> ans = new LinkedList<String>();
		pres(head, ans);
		return ans;
	}
	
	public static void pres(Node head, Queue<String> ans) {
		if (head == null) {
			ans.add(null);
		} else {
			ans.add(String.valueOf(head.value));
			pres(head.left, ans);
			pres(head.right, ans);
		}
	}
	
	public static Node buildByPreQueue(Queue<String> ans) {
		if (ans == null || ans.isEmpty()) {
			return null;
		}
		return preb(ans);
	}
	
	public static Node preb(Queue<String> ans) {
		String value = ans.poll();
		if (value == null) {
			return null;
		}
		Node head = new Node(Integer.parseInt(value));
		head.left = preb(ans);
		head.right = preb(ans);
		return head;
	}
	
	
	public static Queue<String> levelSerial(Node head) {
		Queue<String> ans = new LinkedList<String>();
		if (head == null) {
			ans.add(null);
		} else {
			ans.add(String.valueOf(head.value));
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(head);
			while (!queue.isEmpty()) {
				head = queue.poll();
				if (head.left != null) {
					queue.add(head.left);
					ans.add(String.valueOf(head.left.value));
				} else {
					ans.add(null);
				}
				
				if (head.right != null) {
					ans.add(String.valueOf(head.right.value));
					queue.add(head.right);
				} else {
					ans.add(null);
				}
			}
		}
		return ans;
	}
	
	public static Node buildByLevelQueue(Queue<String> levelList) {
		if (levelList == null || levelList.size() == 0) {
			return null;
		}
		Node head = generateNode(levelList.poll());
		Queue<Node> queue = new LinkedList<Node>();
		if (head != null) {
			queue.add(head);
		}
		Node node = null;
		while (!queue.isEmpty()) {
			node = queue.poll();
			node.left = generateNode(levelList.poll());
			node.right = generateNode(levelList.poll());
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		return head;
	}
	
	// for test
	public static Node generateNode(String val) {
		if (val == null) {
			return null;
		}
		return new Node(Integer.parseInt(val));
	}
	
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
	public static boolean isSameValueStructure(Node head1, Node head2) {
		if (head1 == null && head2 != null) {
			return false;
		}
		if (head1 != null && head2 == null) {
			return false;
		}
		if (head1 == null && head2 == null) {
			return true;
		}
		if (head1.value != head2.value) {
			return false;
		}
		return isSameValueStructure(head1.left, head2.left) && isSameValueStructure(head1.right, head2.right);
	}
	
	public static void main(String[] args) {
		int maxLevel = 5;
		int maxValue = 100;
		int testTimes = 1000000;
		for (int i = 0; i < testTimes; i++) {
			Node head = generateRandomBST(maxLevel, maxValue);
			Queue<String> pre = preSerial(head);
			Queue<String> level = levelSerial(head);
			Node preBuild = buildByPreQueue(pre);
			Node levelBuild = buildByLevelQueue(level);
			if (!isSameValueStructure(preBuild, levelBuild)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("finish!");
	}
	
	public static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Node{" +
					"value=" + value +
					'}';
		}
	}
}
