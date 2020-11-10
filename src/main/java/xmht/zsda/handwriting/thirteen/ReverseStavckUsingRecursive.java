package xmht.zsda.handwriting.thirteen;

import java.util.Stack;

/**
 * @author shengjk1
 * @date 2020/11/7
 */
public class ReverseStavckUsingRecursive {
	
	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int i = f(stack);
		reverse(stack);
		stack.push(i);
	}
	
	public static int f(Stack<Integer> stack) {
		Integer result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = f(stack);
			stack.push(result);
			return last;
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		reverse(test);
		while (!test.isEmpty()) {
			System.out.println(test.pop());
		}
		
	}
}
