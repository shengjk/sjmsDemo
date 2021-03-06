package xmht.datastructuresandalgorithms.msb.colloctiongranph;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author shengjk1
 * @date 2021/2/23
 */
/*
深度优先遍历
 */
public class DFS {
	public static void dfs(Node node) {
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();

		stack.push(node);
		set.add(node);
		System.out.println(node.value);

		while (!stack.isEmpty()) {
			Node cur = stack.pop();

			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}
}
