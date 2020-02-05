package xmht.datastructuresandalgorithms.datastructure.LinkedList;


/**
 * @author shengjk1
 * @date 2020-02-06
 */

public class Josephus {
	public static void main(String[] args) {
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoys(5);
		circleSingleLinkedList.show();
//		circleSingleLinkedList.ysf(5);
		circleSingleLinkedList.countBoy(1, 2, 5);
	}
}

class CircleSingleLinkedList {
	private Boy first = null;
	private Boy firstPre = null;
	private int nums;
	
	public void addBoys(int nums) {
		if (nums < 1) {
			System.out.println("nums 值不正确 ！");
			return;
		}
		this.nums = nums;
		Boy curBoy = null;
		for (int i = 1; i <= nums; i++) {
			if (i == 1) {
				first = new Boy(i);
				first.setNext(first);
				curBoy = first;
			} else {
				Boy boy = new Boy(i);
				curBoy.setNext(boy);
				curBoy = boy;
				curBoy.setNext(first);
			}
			firstPre = curBoy;
		}
	}
	
		/*
		1.创建一个辅助指针 helper，事先应该指向环形链表的最后一个节点
		2.当小孩报数时，让 first 和 helper 指针同时移动 m-1 次
		3.这时就可以将 first 指向的小孩节点出圈
		first=first.next
		helper.next=first
		 */
	
	//偷懒的方式，借助 firstPre(helper)，简易版的,或者直接通过循环找到 firstPre(helper)
	public void ysf(int m) {
		while (true) {
			for (int i = 1; i < m; i++) {
				first = first.getNext();
				firstPre = firstPre.getNext();
			}
			System.out.println("移除 " + first.getNo());
			first = first.getNext();
			firstPre.setNext(first);
			if (firstPre == first) {
				System.out.println("移除 " + first.getNo());
				break;
			}
		}
	}
	
	
	/**
	 * 复杂版，逻辑与简易版类似
	 *
	 * @param startNo  表示从第几个小孩开始数数
	 * @param countNum 表示数几下
	 * @param nums     表示最初有多少个小孩在权重
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		if (first == null || startNo < 1 || startNo > this.nums || nums > this.nums) {
			System.out.println("参数有误，请重新输入！");
			return;
		}
		Boy helper = first;
		while (true) {
			//直接移动到 startNo
			if (helper.getNext().getNo() == startNo) {
				break;
			}
			helper = helper.getNext();
		}
		first = helper.getNext();
		
		while (true) {
			if (helper == first) {
				System.out.println("最后留在圈中的小孩是 " + first.getNo());
				break;
			}
			
			for (int i = 1; i < countNum; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.println("移除小孩 " + first.getNo());
			first = first.getNext();
			helper.setNext(first);
		}
	}
	
	
	public void show() {
		if (first == null) {
			System.out.println("单向循环链表表为 null");
			return;
		} else {
			Boy curBoy = first;
			while (true) {
				System.out.println("boy num " + curBoy.getNo());
				curBoy = curBoy.getNext();
				if (curBoy == first) {
					break;
				}
			}
		}
	}
}

class Boy {
	private int no;
	private Boy next;
	
	public Boy(int no) {
		this.no = no;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public Boy getNext() {
		return next;
	}
	
	public void setNext(Boy next) {
		this.next = next;
	}
}