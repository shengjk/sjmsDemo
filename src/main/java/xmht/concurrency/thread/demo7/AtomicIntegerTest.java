package xmht.concurrency.thread.demo7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shengjk1
 * @date 2020/1/7
 */
public class AtomicIntegerTest {
	static AtomicInteger ai = new AtomicInteger(1);
	
	public static void main(String[] args) {
		System.out.println(ai.getAndIncrement());
		System.out.println(ai.get());
	}
}
