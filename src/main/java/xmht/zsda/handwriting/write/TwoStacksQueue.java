package xmht.zsda.handwriting.write;

import java.util.Stack;

/**
 * @author shengjk1
 * @date 2020/11/2
 */
/*
over
1. pop 为空的时候才能倒数据
2. 倒数据的时候需要将push栈的所有数据一下子倒完
 */
public class TwoStacksQueue {
	private Stack<Integer> pop;
	private Stack<Integer> push;
	
	public TwoStacksQueue() {
		pop = new Stack<>();
		push = new Stack<>();
	}
	
	public void pushToPop() {
		if (pop.isEmpty()) {
			while (!push.isEmpty()) {
				pop.push(push.pop());
			}
		}
	}
	
	public void add(int i) {
		push.add(i);
		pushToPop();
	}
	
	public int pop() {
		pushToPop();
		if (pop.isEmpty()) {
			throw new RuntimeException("queue is empty");
		}
		return pop.pop();
	}
	
	public int peek() {
		pushToPop();
		if (pop.isEmpty()) {
			throw new RuntimeException("queue is empty");
		}
		return pop.peek();
	}
}
