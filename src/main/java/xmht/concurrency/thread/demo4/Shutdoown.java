package xmht.concurrency.thread.demo4;


import java.util.concurrent.TimeUnit; /**
 * @author shengjk1
 * @date 2019/8/27
 */

/**
 * 通过 volatile 或者 interrupt 来优雅的停止线程
 */
public class Shutdoown {
	public static void main(String[] args) {
		Runner one = new Runner();
		Thread countThread = new Thread(one, "CountThread");
		countThread.start();
		
		try {
			//保证线程已启动
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
		}
		countThread.interrupt();
		one.cancel();
//

//		Runner two = new Runner();
//		Thread countThread = new Thread(two, "CountThreadqqqqq");
//		//异步执行
//		countThread.start();
//
//		// 不等这个 countThread.start() 返回，two.cancel() 这个就开始执行了
//		two.cancel();
		System.out.println("two thread stoped");
	}
	
	private static class Runner implements Runnable {
		private long i;
		private volatile boolean running = true;
		
		@Override
		public void run() {
			System.out.println("current Thread Name start:" + Thread.currentThread().getName());
			while (running && !Thread.currentThread().isInterrupted()) {
				System.out.println("=== " + Thread.currentThread().isInterrupted());
				i++;
				
				try {
					//保证线程已启动
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
			System.out.println("Count i= " + i);
			System.out.println("current Thread Name stop:" + Thread.currentThread().getName());
			
		}
		
		public void cancel() {
			running = false;
			System.out.println("running=false");
		}
	}
}
