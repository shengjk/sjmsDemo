package xmht.javabase.effictjava.chapter03.test08;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shengjk1
 * @date 2019-05-15
 */
public class CounterPoint extends Point {
	private static final AtomicInteger ATOMIC_INTEGER=new AtomicInteger();
	
	public CounterPoint(int x, int y) {
		super(x, y);
		ATOMIC_INTEGER.incrementAndGet();
	}
	
	public int numberCreated(){
		return ATOMIC_INTEGER.get();
	}
}
