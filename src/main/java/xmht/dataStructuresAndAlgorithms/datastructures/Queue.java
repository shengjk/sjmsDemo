package xmht.dataStructuresAndAlgorithms.datastructures;

/**
 * Created by shengjk1 on 2017/6/15 0015
 */

/**
 * 跟stack一样，插入数据或者移除数据时间复杂度O(1)
 */
public class Queue {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nIteams;
	
	public Queue(int s) {
		maxSize=s;
		queArray=new long[maxSize];
		front=0;
		rear=-1;
		nIteams=0;
	}
	
	//nItems不等于maxSize
	public void insert(long j){
		if (rear==maxSize-1){
			rear=-1;
		}
		queArray[++rear]=j;
		nIteams++;
	}
	
	//nItems不等于maxSize
	public long remove(){
		long temp=queArray[front++];
		if (front==maxSize){
			front=0;
		}
		nIteams--;
		return temp;
	}
	
	public long peekFront(){
		return queArray[front];
	}
	
	public boolean isEmpty(){
		return nIteams==0;
	}
	
	public boolean isFull(){
		return nIteams==maxSize;
	}
	
	public int size(){
		return nIteams;
	}
}

class QUeueApp{
	public static void main(String[] args) {
		Queue queue=new Queue(5);
		queue.insert(10);
		queue.insert(101);
		queue.insert(102);
		queue.insert(103);
		queue.insert(104);
//		queue.insert(105);
		
		queue.remove();
		queue.remove();
		queue.remove();
		
		while (!queue.isEmpty()){
			long n =queue.remove();
			System.out.println(n);
		}
	}
}

