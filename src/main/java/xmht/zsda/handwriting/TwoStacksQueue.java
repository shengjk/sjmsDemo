package xmht.zsda.handwriting;

/**
 * @author shengjk1
 * @date 2020/9/7
 */

import java.util.Stack;

/**
 * 两个栈来实现队列
 * <p>
 * 1.pop 为空的时候才可能倒数据
 * 2.倒数据时，把 push 中的数据一下子倒完
 */
public class TwoStacksQueue {
	private Stack<Integer> pushStack;
	private Stack<Integer> popStack;
	
	public TwoStacksQueue() {
		this.pushStack = new Stack();
		this.popStack = new Stack();
	}
	
	public static void main(String[] args) {
		TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
		twoStacksQueue.add(1);
		twoStacksQueue.add(2);
		twoStacksQueue.add(3);
		
		System.out.println(twoStacksQueue.poll());
		System.out.println(twoStacksQueue.poll());
	}
	
	//push 栈向 pop 栈倒数据
	private void pushToPop() {
		if (popStack.isEmpty()) {
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
	}
	
	public void add(int pushInt) {
		pushStack.push(pushInt);
		pushToPop();
	}
	
	public int poll() {
		if (popStack.empty() && pushStack.empty()) {
			throw new RuntimeException("Queue is empty!");
		}
		pushToPop();
		return popStack.pop();
	}
	
	public int peek() {
		if (popStack.empty() && pushStack.empty()) {
			throw new RuntimeException("Queue is empty!");
		}
		pushToPop();
		return popStack.peek();
	}
}
