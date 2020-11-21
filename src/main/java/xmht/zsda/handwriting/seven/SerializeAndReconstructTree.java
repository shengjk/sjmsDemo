package xmht.zsda.handwriting.seven;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shengjk1
 * @date 2020/11/18
 */
// 树的序列化和反序列化
public class SerializeAndReconstructTree {
	public static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static Queue<String> preSerial(Node head) {
		Queue<String> ans = new LinkedList<>();
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
	
	public static Node preb(Queue<String> preList) {
		String value = preList.poll();
		if (value == null) {
			return null;
		}
		Node head = new Node(Integer.valueOf(value));
		head.left = preb(preList);
		
	}
}
