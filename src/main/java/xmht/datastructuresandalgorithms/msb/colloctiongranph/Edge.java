package xmht.datastructuresandalgorithms.msb.colloctiongranph;

/**
 * @author shengjk1
 * @date 2021/2/23
 */
public class Edge {
	public int  weight;
	public Node from;
	public Node to;

	public Edge(int weight, Node from, Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}
}
