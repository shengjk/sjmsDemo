package xmht.datastructuresandalgorithms.msb.colloctiongranph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shengjk1
 * @date 2021/2/23
 */
public class TopologySort {

	public static ArrayList<Node> topologySort(Graph graph) {
		HashMap<Node, Integer> nodeInHashMap = new HashMap<>();
		//所有 node 的入度为0
		Queue<Node> zeroInQueue = new LinkedList<>();

		for (Node node : graph.nodes.values()) {
			nodeInHashMap.put(node, node.in);
			if (node.in == 0) {
				zeroInQueue.add(node);
			}
		}

		ArrayList<Node> nodes = new ArrayList<>();
		while (!zeroInQueue.isEmpty()) {
			Node cur = zeroInQueue.poll();
			nodes.add(cur);

			for (Node next : cur.nexts) {
				nodeInHashMap.put(next, nodeInHashMap.get(next) - 1);
				if (nodeInHashMap.get(next) == 0) {
					nodes.add(next);
				}
			}
		}
		return nodes;
	}
}
