package xmht.concurrency.thread.demo4;

import java.util.concurrent.TimeUnit;

/**
 * @author shengjk1
 * @date 2019/9/2
 */
/*
 ThreadLocal,是一个以 ThreadLocal 对象为键、任意对象为值的存储结构。
 这个结构可以被附带在线程上，也就是说一个线程可以根据一个 ThreadLocal 对象查询到绑定在这个线程上的值
 
 ThreadLocal 仅与线程有关
 */
public class ProfilerThreadLocal {
	private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
		@Override
		protected Long initialValue() {
			return System.currentTimeMillis();
		}
	};
	
	
	public static final void begin() {
		TIME_THREADLOCAL.set(System.currentTimeMillis());
	}
	
	public static final long end() {
		return System.currentTimeMillis() - TIME_THREADLOCAL.get();
	}
	
	public static void main(String[] args) {
		ProfilerThreadLocal.begin();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Cost: " + ProfilerThreadLocal.end() + " mills");
	}
}
