package xmht.concurrency.thread.demo4;

import java.util.concurrent.TimeUnit;

/**
 * @author shengjk1
 * @date 2019/9/2
 */

/*
如果一个线程 A 执行了 thread.join 语句，其含义是 当前线程 A 等待 thread 线程终止后才从 thread.join 返回
这里涉及了 等待/通知 机制( 等待前驱线程结束，接受前驱线程结束通知 )
 */
public class Join {
	public static void main(String[] args) {
		Thread previout = Thread.currentThread();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Domino(previout), String.valueOf(i));
			thread.start();
			previout = thread;
		}
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " terminate");
	}
	
	static class Domino implements Runnable {
		private Thread thread;
		
		public Domino(Thread thread) {
			this.thread = thread;
		}
		
		@Override
		public void run() {
			try {
				//join线程终止后，线程的 this.notifyAll() 方法会被调用
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " terminate.");
		}
	}
}
