package xmht.concurrency.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author shengjk1
 * @date 2019/12/26
 */
public class ShutDown {
	public static void main(String[] args) throws InterruptedException {
		Runner runner = new Runner();
		Thread countThread = new Thread(runner, "CountThread");
		countThread.start();
		
		TimeUnit.SECONDS.sleep(1);
		countThread.interrupt();
		
		Runner runner1 = new Runner();
		Thread countThread1 = new Thread(runner1, "CountThread");
		countThread1.start();
		TimeUnit.SECONDS.sleep(1);
		countThread1.interrupt();
		runner1.cacel();
		
		countThread.join();
		countThread1.join();
	}
	
	private static class Runner implements Runnable{
		private long i;
		private volatile boolean on=true;
		
		@Override
		public void run() {
			while (on && !Thread.currentThread().isInterrupted()){
				i++;
			}
			System.out.println("Count i ="+i);
		}
		public void cacel(){
			on=false;
		}
	}
}
