package xmht.datastructuresandalgorithms.datastructure;

/**
 * @author shengjk1
 * @date 2020/1/5
 */
/*
数组模拟环形队列，先进先出
 (front,rear] 前不包后包

 属性定义的好，往往会大大减少逻辑的复杂性
*/

public class ArrayQueue {
	private int maxSize;
	private int rear;
	private int front;
	private Integer[] intArr;
	
	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		intArr = new Integer[maxSize];
		rear = -1;
		front = -1;
	}
	
	public void addQueue(int a) {
		if (rear == front + maxSize) {
			System.out.println("queue is full");
		} else {
			rear++;
			intArr[rear % maxSize] = a;
		}
	}
	
	public Integer getQueue() {
		if (rear == front) {
			System.out.println("queue is empty");
			return null;
		} else {
			front++;
			Integer integer = intArr[front % maxSize];
			intArr[front % maxSize] = null;
			return integer;
		}
	}
	
	public void display() {
		System.out.println("front:" + front + " rear:" + rear);
		for (int i = front + 1; i <= rear; i++) {
			System.out.println(intArr[i % maxSize]);
		}
	}
	
	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(10);
		arrayQueue.addQueue(1);
		arrayQueue.addQueue(2);
		arrayQueue.addQueue(3);
		arrayQueue.getQueue();
		arrayQueue.getQueue();
		arrayQueue.addQueue(4);
		arrayQueue.addQueue(5);
		arrayQueue.getQueue();
		arrayQueue.getQueue();
		arrayQueue.getQueue();
		arrayQueue.getQueue();
		arrayQueue.addQueue(4);
		arrayQueue.addQueue(5);
		arrayQueue.addQueue(6);
		arrayQueue.getQueue();
		arrayQueue.getQueue();
		arrayQueue.getQueue();
		arrayQueue.addQueue(7);
		arrayQueue.addQueue(8);
		arrayQueue.addQueue(9);
		arrayQueue.addQueue(10);
		
		arrayQueue.display();
	}
}
