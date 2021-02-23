package xmht.datastructuresandalgorithms.msb.colloctiongranph;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author shengjk1
 * @date 2021/2/21
 */
public class UnionFind {

	static class Node<V> {
		V value;

		public Node(V value) {
			this.value = value;
		}
	}

	static class UnionSet<V> {
		private HashMap<V, Node<V>>       node;
		private HashMap<Node<V>, Node<V>> parent;
		//代表点
		private HashMap<Node<V>, Integer> sizeMap;

		public UnionSet(List<V> nodes) {
			for (V value : nodes) {
				Node<V> vNode = new Node<>(value);
				node.put(value, vNode);
				parent.put(vNode, vNode);
				sizeMap.put(vNode, 1);
			}
		}

		public Node<V> findParent(Node<V> node) {

			Stack<Node<V>> stack = new Stack<>();
			while (node != parent.get(node)) {
				stack.push(node);
				node = parent.get(node);
			}

			while (!stack.isEmpty()) {
				parent.put(stack.pop(), node);
			}

			return node;
		}

		public boolean isSameSet(V x, V y) {
			if (!node.containsKey(x) || !node.containsKey(y)) {
				return false;
			}
			return findParent(node.get(x)) == findParent(node.get(y));
		}

		public void union(V x, V y) {
			if (!node.containsKey(x) || !node.containsKey(y)) {
				return;
			}

			Node<V> xparent = findParent(node.get(x));
			Node<V> yparent = findParent(node.get(y));

			if (xparent != yparent) {
				int xsize = sizeMap.get(xparent);
				int ysize = sizeMap.get(yparent);
				Node<V> big = xsize >= ysize ? xparent : yparent;
				Node<V> simall = big == xparent ? yparent : xparent;

				parent.put(simall, big);
				sizeMap.put(big, xsize + ysize);
				sizeMap.remove(simall);

			}
		}
	}
}
