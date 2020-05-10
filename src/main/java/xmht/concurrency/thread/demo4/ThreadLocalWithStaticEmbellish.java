package xmht.concurrency.thread.demo4;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalWithStaticEmbellish implements Runnable {
	
	private static final int NCPU = Runtime.getRuntime().availableProcessors();
	private static final int a = 1;
	
	//还是一个线程会初始化一个 ThreadLocal
	private static final ThreadLocal<List<String>> threadLocal = ThreadLocal.withInitial(() -> {
		System.out.println("thread-" + Thread.currentThread().getName() + " init thread local");
		return new ArrayList<>();
	});
	
	public static void main(String[] args) throws Exception {
		ThreadLocalWithStaticEmbellish tl = new ThreadLocalWithStaticEmbellish();
		for (int i = 0; i < NCPU + 1; i++) {
			Thread thread = new Thread(tl, String.valueOf((char) (i + 97)));
			thread.start();
			thread.join();
		}
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			List<String> li = threadLocal.get();
			li.add(Thread.currentThread().getId() + "_" + Math.random());
			threadLocal.set(li);
		}
		System.out.println("[Thread-" + Thread.currentThread().getName() + "], list=" + threadLocal.get());
	}
}