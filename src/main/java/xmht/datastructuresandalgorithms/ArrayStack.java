package xmht.datastructuresandalgorithms;

import java.util.Stack;

/**
 * @author shengjk1
 * @date 2019-06-23
 */
/*
固定长度的数据实现栈和队列
 */
public class ArrayStack {
	private final Integer[] arr;
	private Integer index;
	
	public ArrayStack(int initSize) {
		if (initSize < 0) {
			throw new IllegalArgumentException("this initSize is less than 0");
		}
		arr = new Integer[initSize];
		index = 0;
	}
	
	public Integer peek() {
		if (index == 0) {
			return null;
		}
		return arr[index - 1];
	}
	
	public void push(int obj) {
		if (index == arr.length) {
			throw new ArrayIndexOutOfBoundsException("the queue is full");
		}
		arr[index++] = obj;
	}
	
	public Integer pop() {
		if (index == 0) {
			throw new ArrayIndexOutOfBoundsException("this queue is empty");
		}
		return arr[--index];
	}
	
	
	public static class ArrayQueue {
		private final Integer[] arr;
		private Integer size;
		private Integer start;
		private Integer end;
		
		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("this initSize is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
			start = 0;
			end = 0;
		}
		
		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[start];
		}
		
		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("this queue is full");
			}
			size++;
			arr[end] = obj;
			end = end == arr.length - 1 ? 0 : end + 1;
		}
		
		public Integer poll() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("this queue is empty");
			}
			size--;
			int tmp = start;
			start = start == arr.length - 1 ? 0 : start + 1;
			return arr[tmp];
		}
	}
	/*
	实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
	要求
	1. pop、push、getMin操作的时间复杂度都是 O(1)
	2. 设计的栈类型可以使用现成的栈结构
	 */
	
	public static class MyStack2 {
		private final Stack<Integer> stackData;
		private final Stack<Integer> stackMin;
		
		public MyStack2() {
			this.stackData = new Stack<>();
			this.stackMin = new Stack<>();
		}
		
		public void push(int newNum) {
			if (this.stackMin.isEmpty()) {
				this.stackMin.push(newNum);
			} else if (newNum < this.getmin()) {
				this.stackMin.push(newNum);
			} else {
				int newMin = this.stackMin.peek();
				this.stackMin.push(newMin);
			}
			this.stackData.push(newNum);
		}
		
		public int pop() {
			if (this.stackData.isEmpty()) {
				throw new RuntimeException("stack is empty");
			}
			this.stackMin.pop();
			return this.stackData.pop();
		}
		
		public int getmin() {
			if (this.stackMin.isEmpty()) {
				throw new RuntimeException("stack is empyt");
			}
			return this.stackMin.peek();
		}
	}
}
