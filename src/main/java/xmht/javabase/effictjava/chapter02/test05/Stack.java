// Can you spot the "memory leak"?
package xmht.javabase.effictjava.chapter02.test05;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	
	public Object pop() {
		if (size == 0){
			throw new EmptyStackException();
		}
		/*
		如果一个栈先是增长，然后再收缩，那么，从栈中弹出来的对象将不会被当做垃圾回收，即使使用栈的程序不再引用这些对象，他们也不会被回收。
		这是因为，栈内部维护着对这些对象的过期引用。所谓的过期引用，是指永远也不会再被解除的应用
		在支持垃圾回收的语言中，内存泄露是很隐蔽的(无意识的对象保存更为恰当)，如果一个对象引用被无意识地保留起来了，那么。垃圾回收机制不仅不会处理这个对象
		而且也不会处理被这个对象所引用的所有的其他对象。
		
		修复方法也很简单：一旦对象引用已经过期，只需要清空这些引用即可
		
		清空过期引用的另一个好处是，如果他们以后又被错误的解除引用，程序会立即抛出NullPointException异常，而不是悄悄的错误运行下去。尽快的检测出错误总是有益的
		清空对象引用应该是一种例外，而不是一种规范行为
		消息过期引用最好的方法是让包含引用的变量结束其生命周期。如果你是在最紧凑的作用域范围内定义每一个变量，这种情形就会自然而然的发生
		 */
		return elements[--size];
	}
	
	
	public Object fixPop() {
		if (size == 0){
			throw new EmptyStackException();
		}
		/*
		如果一个栈先是增长，然后再收缩，那么，从栈中弹出来的对象将不会被当做垃圾回收，即使使用栈的程序不再引用这些对象，他们也不会被回收。
		这是因为，栈内部维护着对这些对象的过期引用。所谓的过期引用，是指永远也不会再被解除的应用
		在支持垃圾回收的语言中，内存泄露是很隐蔽的(无意识的对象保存更为恰当)，如果一个对象引用被无意识地保留起来了，那么。垃圾回收机制不仅不会处理这个对象
		而且也不会处理被这个对象所引用的所有的其他对象。
		
		修复方法也很简单：一旦对象引用已经过期，只需要清空这些引用即可
		 */
		Object result = elements[--size];
		elements[size]=null;
		return result;
	}
	
	
	/**
	 * Ensure space for at least one more element, roughly doubling the capacity
	 * each time the array needs to grow.
	 */
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
}
