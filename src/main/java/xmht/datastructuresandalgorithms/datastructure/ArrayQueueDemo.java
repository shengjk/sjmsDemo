package xmht.datastructuresandalgorithms.datastructure;

/**
 * @author shengjk1
 * @date 2019-07-22
 */
public class ArrayQueueDemo {
	public static void main(String[] args) {
	
	}
}

class ArrayQueue{
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;
	
	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		arr=new int[this.maxSize];
		this.front=-1;
		this.rear=-1;
	}
	
	public boolean isFull(){
		return rear==maxSize-1;
	}
	
	public boolean isEmpty(){
		return rear==-1;
	}
	
	public void add(int a){
		rear++;
		
	}
}
