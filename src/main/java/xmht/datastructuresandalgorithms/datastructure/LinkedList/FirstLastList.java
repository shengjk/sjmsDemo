package xmht.datastructuresandalgorithms.datastructure.LinkedList;

/**
 * @author shengjk1
 * @date 2019-07-02
 */

/**
 * 双端链表
 * 对最后一个链结点的引用，就像是对第一个链结点的引用一样
 */
public class FirstLastList {
	private Link first;
	private Link last;
}

/**
 * 基本的数据结构还是不变
 */
class LinkFirstLast {
	public long dData;
	public Link next;
	
	
	public LinkFirstLast(long dData) {
		this.dData = dData;
	}
	
	public void dispalyLink() {
		System.out.println(dData + "");
	}
}