package xmht.DataStructuresAndAlgorithms;

/**
 * Created by shengjk1 on 2017/5/19 0019
 */
//出栈入栈 O(1)
public class Stackx {
	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public Stackx(int s) {
		this.maxSize = s;
		this.stackArray = new long[maxSize];
		this.top = -1;
	}
	
	public  void push(long j){
		stackArray[++top]=j;
	}
	public long pop(){
		return stackArray[top--];
	}
	
	public long peek(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	public  boolean isFull(){
		return top==maxSize-1;
	}
}

class StackApp{
	public static void main(String[] args) {
		Stackx stackX=new Stackx(1);
		if(!stackX.isFull()){//需要在stack的内部进行检测
			stackX.push(20);
			stackX.push(40);
			stackX.push(60);
			stackX.push(80);
			stackX.push(100);
			stackX.push(20);
		}
		
		while (!stackX.isEmpty()){
			long value=stackX.pop();
			System.out.println(value);
			System.out.println("");
		}
		System.out.println("");
	}
}

