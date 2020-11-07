package xmht.zsda.handwriting.write;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author shengjk1
 * @date 2020/11/2
 */
/*
over

help 与 data 来回交换
 */
public class TwoQueueStacks {
	private Queue<Integer> data;
	private Queue<Integer> help;
	
	public TwoQueueStacks() {
		data = new LinkedList<>();
		help = new LinkedList<>();
	}
	
	public static void main(String[] args) {
		Stack<Integer> integers = new Stack<>();
	}
	
	public void push(int i) {
		data.add(i);
	}
	
	public int pop() {
		if (data.isEmpty()) {
			throw new RuntimeException("stack is empty");
		}
		while (data.size() > 1) {
			help.add(data.poll());
		}
		Integer result = data.poll();
		
		Queue<Integer> tmp = data;
		data = help;
		help = tmp;
		return result;
	}
}
