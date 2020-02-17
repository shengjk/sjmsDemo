package xmht.datastructuresandalgorithms.datastructure.stack;

/**
 * @author shengjk1
 * @date 2020/2/13
 */
public class ArrayStackDemo {
	
	
	public static void main(String[] args) {
	
	}
}

class ArrayStack {
	private int maxSize;
	private int[] stack;
	private int top = -1;
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	
	
	// 栈满
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	//栈空
	public boolean isEmpty() {
		return top == -1;
	}
	
	//入栈
	public void push(int element) {
		if (isFull()) {
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top] = element;
	}
	
	//出栈
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("stack is empty!");
		}
		int temp = stack[top];
//		stack[top]=null; 防止内存泄露
		top--;
		return temp;
		
	}
}
