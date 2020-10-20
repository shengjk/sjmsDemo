package xmht.zsda.handwriting.two;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shengjk1
 * @date 2020/10/4
 */
public class TwoQueueImpalementStack {
	
	public static class TwoQueueStack<T> {
		public Queue<T> queue;
		public Queue<T> help;
		
		public TwoQueueStack() {
			queue = new LinkedList<>();
			help = new LinkedList<>();
		}
		
		public void push(T value) {
			queue.offer(value);
		}
		
		public T poll() {
			while (queue.size() > 1) {
				help.offer(queue.poll());
			}
			T ans = queue.poll();
			Queue<T> tmp = this.queue;
			queue = help;
			help = tmp;
			return ans;
		}
		
		public T peek() {
			while (queue.size() > 1) {
				help.offer(queue.poll());
			}
			T ans = queue.poll();
			help.offer(ans);
			Queue<T> tmp = this.queue;
			queue = help;
			help = tmp;
			return ans;
		}
	}
}
