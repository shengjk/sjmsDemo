package xmht.datastructuresandalgorithms.datastructure.LinkedList;

/**
 * @author shengjk1
 * @date 2020/1/5
 */
public class SingleLinkedList {
	private HeroNode headNode;
	private HeroNode currentNode;
	private HeroNode previousNode;
	
	public SingleLinkedList() {
		this.headNode = new HeroNode();
	}
	
	//在最后添加
	public void addHero(HeroNode heroNode) {
		if (currentNode == null) {
			headNode.setNext(heroNode);
			previousNode = headNode;
			currentNode = heroNode;
		} else {
			previousNode = currentNode;
			currentNode.setNext(heroNode);
			currentNode = heroNode;
		}
	}
	
	
	public static void main(String[] args) {
	
	}
}

class HeroNode {
	private int no;
	private String name;
	private String nickName;
	private HeroNode next;
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public HeroNode getNext() {
		return next;
	}
	
	public void setNext(HeroNode next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "HeroNode{" +
				"no=" + no +
				", name='" + name + '\'' +
				", nickName='" + nickName + '\'' +
				", next=" + next +
				'}';
	}
}