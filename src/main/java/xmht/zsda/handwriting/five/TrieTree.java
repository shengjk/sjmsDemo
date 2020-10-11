package xmht.zsda.handwriting.five;

import java.util.HashMap;

/**
 * @author shengjk1
 * @date 2020/10/9
 */
/*
前缀树
 */
public class TrieTree {
	
	public static class Node {
		public int pass;
		public int end;
		public HashMap<Integer, Node> next;
		
		public Node() {
			this.pass = 0;
			this.end = 0;
			this.next = new HashMap<>();
		}
	}
	
	public static class Trie {
		private Node root;
		
		public Trie() {
			root = new Node();
		}
		
		public void insert(String word) {
			if (word == null) {
				return;
			}
			
			Node node = root;
			node.pass++;
			char[] chars = word.toCharArray();
			for (char aChar : chars) {
				int path = aChar;
				if (!node.next.containsKey(path)) {
					node.next.put(path, new Node());
				}
				node.pass++;
				node = node.next.get(path);
			}
			node.end++;
		}
		
		
		public void delete(String word) {
			if (search(word) == 0) {
				return;
			}
			Node node = root;
			node.pass--;
			char[] chars = word.toCharArray();
			for (char aChar : chars) {
				int path = aChar;
				if (--node.next.get(path).pass == 0) {
					node.next.remove(path);
					return;
				}
				node = node.next.get(path);
			}
		}
		
		
		//word 这个单词在之前加入过几次
		public int search(String world) {
			if (world == null) {
				return 0;
			}
			
			Node node = root;
			char[] chars = world.toCharArray();
			for (char aChar : chars) {
				int path = aChar;
				if (!node.next.containsKey(path)) {
					return 0;
				}
				node = node.next.get(path);
			}
			return node.end;
		}
		
		//所有加入的字符串中，有几个是以 pre 这个字符串作为前缀
		public int preFixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			
			Node node = root;
			char[] chars = pre.toCharArray();
			for (char aChar : chars) {
				int path = aChar;
				if (!node.next.containsKey(path)) {
					return 0;
				}
				node = node.next.get(path);
			}
			return node.pass;
		}
	}
}
