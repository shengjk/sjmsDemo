package xmht.DataStructuresAndAlgorithms;

/**
 * Created by shengjk1 on 2017/5/19 0019
 */
//指针回绕，插入数据和取出数据O(1)
public class Queue {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue(int s) {
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(long j) {
		if (rear == maxSize - 1) {
			rear = -1;
		}
		queArray[++rear] = j;
		nItems++;
	}
	
	public long remove() {
		long temp = queArray[front++];
		if (front == maxSize) {
			front = 0;
		}
		nItems--;
		return temp;
	}
	
	public long peekFront(){
		return queArray[front];
	}
	
	public boolean isEmpty(){
		return nItems==0;
	}
	public  boolean isFull(){
		return nItems==maxSize;
	}
	public int size(){
		return nItems;
	}
}

class QueueApp{
	public static void main(String[] args) {
		Queue queue=new Queue(5);
		queue.insert(10);
		queue.insert(120);
		queue.insert(130);
		queue.insert(140);
		queue.insert(150);
		
		System.out.println(queue.size());
		
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		
		System.out.println(queue.size());
		
		queue.insert(10);
		queue.insert(120);
		queue.insert(130);
		queue.insert(140);
		queue.insert(150);
		
		while (!queue.isEmpty()){
			long n =queue.remove();
			System.out.println(n);
		}
		System.out.println();
	}
}
