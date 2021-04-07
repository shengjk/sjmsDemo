package xmht;

import java.util.PriorityQueue;

/**
 * @author shengjk1
 * @date 2021/4/5
 */
public class Test {
	public static void main(String[] args) {
		PriorityQueue<Integer> integers = new PriorityQueue<>();
		System.out.println(integers.add(1));
		System.out.println(integers.add(1));
		System.out.println(integers.add(1));
		integers.add(1);
		integers.add(1);

		System.out.println(integers.size());
		System.out.println(integers.poll());
		System.out.println(integers.poll());
		System.out.println(integers.poll());
		System.out.println(integers.poll());
	}
}
