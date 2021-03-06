package xmht.datastructuresandalgorithms.msb.colloctiongranph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shengjk1
 * @date 2021/2/23
 */
/*
宽度优先遍历
 */
public class BFS {

	public static void bfs(Node node) {
		Queue<Node> queue = new LinkedList<>();
		HashSet<Node> set = new HashSet<>();

		queue.add(node);
		set.add(node);

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur);

			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					set.add(next);
					queue.add(next);
				}
			}
		}
	}
}
