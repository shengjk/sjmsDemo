package xmht.datastructuresandalgorithms.datastructure;

/**
 * @author shengjk1
 * @date 2019-07-02
 */

/**
 * 双向链表 允许向前向后遍历整个链表
 */
public class DoublyLinked {
	private DoublyLink next;
	private DoublyLink previous;
	
	public DoublyLinked() {
		this.next = null;
		this.previous = null;
	}
	
	public boolean isEmpty(){
		return true;
	}
}

class DoublyLink{
	public long dData;
	public Link next;
	public Link previous;
	
	public DoublyLink(long dData) {
		this.dData = dData;
	}
	
	public void dispalyLink(){
		System.out.println(dData+"");
	}
}