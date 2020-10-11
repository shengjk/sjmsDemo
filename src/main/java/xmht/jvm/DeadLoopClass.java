package xmht.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author shengjk1
 * @date 2020/9/8
 */
public class DeadLoopClass {
	
	
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread() + " start");
				DeadLoopClass1 deadLoopClass = new DeadLoopClass1();
				System.out.println(Thread.currentThread() + " run over");
			}
		};
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		thread1.start();
		thread2.start();
	}
	
	static class DeadLoopClass1 {
		static {
			if (true) {
				System.out.println(Thread.currentThread() + " init DeafLoopClass");
				while (true) {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
