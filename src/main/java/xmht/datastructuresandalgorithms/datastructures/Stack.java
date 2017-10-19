package xmht.datastructuresandalgorithms.datastructures;

/**
 * Created by shengjk1 on 2017/6/15 0015
 */

/**
 * normal,stack's capacity is samll
 * stack 入栈、出栈时间复杂度O(1)
 */
class StackX{
	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public StackX(int s) {
		maxSize=s;
		stackArray=new long[maxSize];
		top=-1; //no items yet
	}
	
	public void push(long i){
		stackArray[++top]=i;
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
	
	public boolean isFull(){
		return top==maxSize;
	}
}

class StackApp{
	public static void main(String[] args) {
		StackX stackX=new StackX(10);
		stackX.push(20);
		stackX.push(204);
		stackX.push(206);
		stackX.push(208);
		stackX.push(200);
		stackX.push(2002);
		
		while (!stackX.isEmpty()){
			long value=stackX.pop();
			System.out.println(value);
		}
	}
}

