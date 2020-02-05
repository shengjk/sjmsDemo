package xmht.datastructuresandalgorithms.datastructure.LinkedList;

import java.util.Objects;

/**
 * @author shengjk1
 * @date 2020/1/5
 */
public class SingleLinkedList {
	private HeroNode headNode;
	
	public SingleLinkedList() {
		this.headNode = new HeroNode();
	}
	
	public SingleLinkedList(HeroNode headNode) {
		this.headNode = headNode;
	}
	
	//在最后添加
	public void addHero(HeroNode node) {
		HeroNode tmp = headNode;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
		}
		tmp.setNext(node);
	}
	
	
	public void addHeroByOrder1(HeroNode node) {
		HeroNode tmp = headNode;
		HeroNode tmpPro = headNode;
		if (tmp.getNext() == null) {
			tmp.setNext(node);
		}
		while (tmp.getNext() != null) {
			tmpPro = tmp;
			//其实一个变量就可以了，tmp 和 tmp.next
			tmp = tmp.getNext();
			if (tmpPro.getNo() < node.getNo() && tmp.getNo() > node.getNo()) {
				node.setNext(tmp);
				tmpPro.setNext(node);
				break;
			} else if (tmpPro.getNo() == node.getNo()) {
				System.out.println("存在相同编号的 hero");
				return;
			}
		}
		if (tmp.getNext() == null) {
			if (tmp.getNo() < node.getNo()) {
				tmp.setNext(node);
			}
		} else {
		
		}
	}
	
	//=====
	public void addHeroByOrder(HeroNode node) {
		HeroNode tmp = headNode;
		while (true) {
			if (tmp.getNext() == null) {
				break;
			}
			if (tmp.getNext().getNo() > node.getNo()) {
				break;
			}
			tmp = tmp.getNext();
		}
		
		if (tmp.getNext() == null) {
			tmp.setNext(node);
		} else {
			node.setNext(tmp.getNext());
			tmp.setNext(node);
		}
	}
	
	
	public void addFirstHero(HeroNode heroNode) {
		if (headNode.getNext() == null) {
			headNode.setNext(heroNode);
		} else {
			HeroNode tmp = headNode.getNext();
			heroNode.setNext(tmp);
			headNode.setNext(heroNode);
		}
	}
	
	//在最后删除
	public void deleteHero() {
		HeroNode tmp = headNode;
		HeroNode tmpPro = headNode;
		while (tmp.getNext() != null) {
			tmpPro = tmp;
			tmp = tmp.getNext();
		}
		tmpPro.setNext(null);
	}
	
	
	public void deleteHero(HeroNode heroNode) {
		HeroNode tmp = headNode;
		boolean tag = false;
		while (true) {
			if (tmp.getNext() == null) {
				break;
			}
			if (tmp.getNext().getNo() == heroNode.getNo()) {
				tag = true;
				break;
			}
			tmp = tmp.getNext();
		}
		if (tag) {
			tmp.setNext(tmp.getNext().getNext());
		} else {
			System.out.println("为找到该 node 节点 " + heroNode.getNo());
		}
	}
	
	//查找某位英雄
	public boolean findHero(HeroNode node) {
		HeroNode tmp = headNode;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
			if (tmp.equals(node)) {
				System.out.println("find hero " + node);
				return true;
			}
		}
		return false;
	}
	
	
	public HeroNode getHeadNode() {
		return this.headNode;
	}
	
	//reverse list
	public void reverseList(HeroNode headNode) {
		HeroNode cur = headNode.getNext();
		HeroNode next = null;
		HeroNode tmpHeadNode = new HeroNode();
		
		while (cur != null) {
			next = cur.getNext();
			cur.setNext(tmpHeadNode.getNext());
			tmpHeadNode.setNext(cur);
			cur = next;
		}
		this.headNode.setNext(tmpHeadNode.getNext());
	}
	
	
	//合并两个有序的链表最后形成一个有序的链表
	public HeroNode mergeList(HeroNode headNode1, HeroNode headNode2) {
		HeroNode tmpHeroNode = new HeroNode();
		HeroNode tmp1 = headNode1.getNext();
		HeroNode tmp2 = headNode2.getNext();
		while (true) {
			if (tmp1 == null) {
				while (tmp2.getNext() != null) {
					tmp1 = tmp2.getNext();
					tmp2.setNext(tmpHeroNode.getNext());
					tmpHeroNode.setNext(tmp2);
					tmp2 = tmp1.getNext();
				}
				return tmpHeroNode;
			}
			if (tmp2 == null) {
				while (tmp1.getNext() != null) {
					tmp2 = tmp1.getNext();
					tmp1.setNext(tmpHeroNode.getNext());
					tmpHeroNode.setNext(tmp1);
					tmp1 = tmp2.getNext();
				}
				return tmpHeroNode;
			}
			
			if (tmp1.getNext().getNo() >= tmp2.getNext().getNo()) {
				tmp1.setNext(tmpHeroNode.getNext());
				tmpHeroNode.setNext(tmp1);
				tmp1 = tmp1.getNext();
			} else {
				tmp2.setNext(tmpHeroNode.getNext());
				tmpHeroNode.setNext(tmp2);
				tmp2 = tmp2.getNext();
			}
		}
	}
	
	
	public HeroNode mergeList1(HeroNode headNode1, HeroNode headNode2) {
		SingleLinkedList singleLinkedList = new SingleLinkedList(headNode2);
		HeroNode tmp = headNode1;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
			singleLinkedList.addHeroByOrder(new HeroNode(tmp));
			System.out.println(tmp.getName());
		}
		return headNode2;
	}
	
	
	public void display() {
		HeroNode tmp = headNode;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
			System.out.println(tmp.getName());
		}
	}
	
	
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		HeroNode heroNode = new HeroNode();
		heroNode.setNo(6);
		heroNode.setName("a");
		heroNode.setNickName("a");
		singleLinkedList.addHeroByOrder(heroNode);
		
		heroNode = new HeroNode();
		heroNode.setNo(1);
		heroNode.setName("b");
		heroNode.setNickName("bb");
		singleLinkedList.addHeroByOrder(heroNode);
		
		heroNode = new HeroNode();
		heroNode.setNo(10);
		heroNode.setName("c");
		heroNode.setNickName("cc");
		singleLinkedList.addHeroByOrder(heroNode);
		
		heroNode = new HeroNode();
		heroNode.setNo(8);
		heroNode.setName("d");
		heroNode.setNickName("dd");
		singleLinkedList.addHeroByOrder(heroNode);
		System.out.println("addHeroByOrder=======");
		singleLinkedList.display();
		HeroNode headNode = singleLinkedList.getHeadNode();

//		HeroNode headNode = singleLinkedList.getHeadNode();
//		singleLinkedList.reverseList(headNode);
//		System.out.println("========+");
//		singleLinkedList.display();
//
//		singleLinkedList.reverseList(headNode);
//		System.out.println("========++");
//		singleLinkedList.display();
//		System.out.println();
//		singleLinkedList.display();
//
		
		SingleLinkedList singleLinkedList1 = new SingleLinkedList();
		heroNode = new HeroNode();
		heroNode.setNo(1);
		heroNode.setName("a");
		heroNode.setNickName("a");
		singleLinkedList1.addHeroByOrder(heroNode);
		
		heroNode = new HeroNode();
		heroNode.setNo(4);
		heroNode.setName("b");
		heroNode.setNickName("bb");
		singleLinkedList1.addHeroByOrder(heroNode);
		
		heroNode = new HeroNode();
		heroNode.setNo(10);
		heroNode.setName("c");
		heroNode.setNickName("cc");
		singleLinkedList1.addHeroByOrder(heroNode);
		HeroNode headNode1 = singleLinkedList1.getHeadNode();
		System.out.println("=================================");
		
		
		System.out.println("merge============");
		HeroNode heroNode1 = singleLinkedList.mergeList1(headNode, headNode1);
		System.out.println(heroNode1);
//		heroNode = new HeroNode();
//		heroNode.setNo(3);
//		heroNode.setName("c");
//		heroNode.setNickName("cc");
//		singleLinkedList.deleteHero(heroNode);
//		System.out.println("delete");
//		singleLinkedList.display();
//
//		System.out.println(singleLinkedList.findHero(heroNode));
	}
}

class HeroNode {
	private int no = -10000;
	private String name;
	private String nickName;
	private HeroNode next;
	
	public HeroNode() {
	}
	
	public HeroNode(HeroNode tmp) {
		this.no = tmp.getNo();
		this.name = tmp.getName();
		this.nickName = tmp.getNickName();
		this.next = null;
	}
	
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
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		HeroNode heroNode = (HeroNode) o;
		return no == heroNode.no &&
				Objects.equals(name, heroNode.name) &&
				Objects.equals(nickName, heroNode.nickName);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(no, name, nickName, next);
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