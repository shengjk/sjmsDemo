package xmht.datastructuresandalgorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author shengjk1
 * @date 2019-06-23
 */
public class StackAndQueueConvert {
	//stackpush 一定要全部倒完
	//stachpop 有数时，一定不能倒  就是队列的正确顺序了
	public static class TwoStacksQueue {
		private final Stack<Integer> statckPush;
		private final Stack<Integer> statckPop;
		
		public TwoStacksQueue() {
			statckPush = new Stack<Integer>();
			statckPop = new Stack<Integer>();
		}
		
		public void push(int pushInt) {
			statckPush.push(pushInt);
		}
		
		public int poll() {
			if (statckPush.isEmpty() && statckPop.isEmpty()) {
				throw new RuntimeException("queue is empty");
			}
			dao();
			return statckPop.pop();
		}
		
		public int peek() {
			if (statckPush.isEmpty() && statckPop.isEmpty()) {
				throw new RuntimeException("queue is empty");
			}
			dao();
			
			return statckPop.peek();
		}
		
		public void dao() {
			if (!statckPop.isEmpty()) {
				return;
			}
			while (!statckPush.isEmpty()) {
				statckPop.push(statckPush.pop());
			}
		}
	}
	
	//用队列实现栈 交换引用
	public static class TwoQueuesStack {
		private Queue<Integer> data;
		private Queue<Integer> help;
		
		public TwoQueuesStack() {
			data = new LinkedList<>();
			help = new LinkedList<>();
		}
		
		public void push(int pushInt) {
			data.add(pushInt);
		}
		
		public int peek() {
			if (data.isEmpty()) {
				throw new RuntimeException("this queue is empty");
			}
			while (data.size() != 1) {
				help.add(data.poll());
			}
			int res = data.poll();
			help.add(res);
			swap();
			return res;
		}
		
		public int pop() {
			if (data.isEmpty()) {
				throw new RuntimeException("this queue is empty");
			}
			while (data.size() != 1) {
				help.add(data.poll());
			}
			int res = data.poll();
			swap();
			return res;
		}
		
		
		//修改引用
		public void swap() {
			Queue<Integer> tmp = help;
			help = data;
			data = tmp;
		}
	}
}
