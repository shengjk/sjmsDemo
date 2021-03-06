package xmht.datastructuresandalgorithms.msb.colloctiongranph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author shengjk1
 * @date 2021/2/23
 */
public class Graph {
	public HashMap<Integer, Node> nodes;
	public HashSet<Edge>          edges;

	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
