package xmht.concurrency.thread.demo4;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shengjk1
 * @date 2019-08-15
 */
public class Counter {
	private final AtomicInteger atomicInteger = new AtomicInteger(0);
	private int i = 0;
	
	public static void main(String[] args) {
		final Counter cas = new Counter();
		
		ArrayList<Thread> ts = new ArrayList<>(600);
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < 100; i++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 1000; j++) {
						cas.count();
						cas.safeCount();
					}
				}
			});
			ts.add(t);
		}
		for (Thread t : ts) {
			t.start();
		}
		
		
		for (Thread t : ts) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(cas.i);
		System.out.println(cas.atomicInteger.get());
		System.out.println(System.currentTimeMillis() - start);
	}
	
	//使用 cas 实现线程安全的计数器
	private void safeCount() {
		for (; ; ) {
			int i = atomicInteger.get();
			boolean suc = atomicInteger.compareAndSet(i, ++i);
			if (suc) {
				break;
			}
		}
	}
	
	/**
	 * 非线程安全的计数器
	 */
	private void count() {
		i++;
	}
}
