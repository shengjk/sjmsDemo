package xmht.datastructuresandalgorithms.datastructure;

/**
 * @author shengjk1
 * @date 2019-07-26
 */
public class SingleLinkedList {
	private HeroNode pre;
	private int length;
	private int nIterms;
	
	public SingleLinkedList(int length) {
		this.length = length;
	}
	
	public void addHeroNode(HeroNode heroNode) {
		if (nIterms == 0) {
			pre = heroNode;
			pre.next = null;
		} else {
			pre.next = heroNode;
			pre.next.next = null;
			pre = pre.next;
		}
		nIterms++;
	}
	
	
	public static void main(String[] args) {
	
	}
}

class HeroNode {
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;
	
	public HeroNode(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
}


