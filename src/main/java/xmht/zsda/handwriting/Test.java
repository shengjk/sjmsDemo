package xmht.zsda.handwriting;

import java.util.LinkedList;

/**
 * @author shengjk1
 * @date 2020/10/3
 */
public class Test {
	public static void main(String[] args) {
//		test(1, 2);
//		System.out.println((a == b) + " " + (integera == integerb));
		
		LinkedList<Integer> integers = new LinkedList<>();
		integers.addFirst(1);
		integers.addFirst(2);
		integers.addLast(10);
		integers.addLast(20);

//		System.out.println(integers.getFirst());
//		System.out.println(integers.getFirst());
//		System.out.println(integers.getFirst());
//		System.out.println(integers.getFirst());
		
		System.out.println(integers.pollLast());
		System.out.println(integers.pollLast());
		System.out.println(integers.pollLast());
		System.out.println(integers.pollLast());
		System.out.println(integers.pollLast());
//		System.out.println(integers.getLast());
		System.out.println(integers.peekLast());
	}
	
	public static void test(int a, int b) {
		System.out.println(a);
		System.out.println(b);
	}
}
