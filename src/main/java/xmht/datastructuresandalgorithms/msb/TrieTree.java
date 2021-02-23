package xmht.datastructuresandalgorithms.msb;

import java.util.HashMap;

/**
 * @author shengjk1
 * @date 2021/2/17
 */
public class TrieTree {
	private Node root;


	public static class Node {
		int                    pass;
		int                    end;
		HashMap<Integer, Node> nexts;

		public Node() {
			this.pass = 0;
			this.end = 0;
			nexts = new HashMap<>();
		}
	}

	public TrieTree() {
		root = new Node();
	}

	public void insert(String str) {
		if (str == null) {
			return;
		}

		Node curNode = root;
		curNode.pass++;
		char[] chars = str.toCharArray();
		int index = 0;
		for (char aChar : chars) {
			index = aChar;

			if (!curNode.nexts.containsKey(index)) {
				curNode.nexts.put(index, new Node());
			}
			curNode = curNode.nexts.get(index);
			curNode.pass++;
		}
		curNode.end++;
	}


	public int search(String str) {
		if (str == null) {
			return 0;
		}
		Node curNode = root;
		char[] chars = str.toCharArray();
		int index = 0;
		for (char aChar : chars) {
			index = aChar;
			curNode = curNode.nexts.get(index);
			if (curNode == null) {
				return 0;
			}
		}
		return curNode.end;
	}

	public int prefixNumber(String str) {
		if (str == null) {
			return 0;
		}
		Node curNode = root;
		char[] chars = str.toCharArray();
		int index = 0;
		for (char aChar : chars) {
			index = aChar;
			curNode = curNode.nexts.get(index);
			if (curNode == null) {
				return 0;
			}
		}
		return curNode.pass;
	}


	public void delete(String str) {
		if (search(str) != 0) {
			char[] chars = str.toCharArray();
			Node node = root;
			node.pass--;
			int index = 0;
			for (char aChar : chars) {
				index = aChar;

				if (--node.nexts.get(index).pass == 0) {
					node.nexts.remove(index);
					return;
				}
				node = node.nexts.get(index);
			}
			node.end--;
		}
	}
}


