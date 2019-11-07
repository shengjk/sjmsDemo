package xmht.thread.demo4;

import java.util.concurrent.TimeUnit;

/**
 * @author shengjk1
 * @date 2019/9/2
 */
public class Join {
	public static void main(String[] args) {
		Thread previout = Thread.currentThread();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Domino(previout), String.valueOf(i));
			thread.start();
			previout=thread;
		}
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" terminate");
	}
	
	static class Domino implements Runnable{
		private Thread thread;
		
		public Domino(Thread thread) {
			this.thread = thread;
		}
		
		@Override
		public void run() {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" terminate.");
		}
	}
}
