package xmht.thread.demo4;


import java.util.concurrent.TimeUnit;

/**
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
//
//		try {
//			TimeUnit.SECONDS.sleep(1);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		countThread.interrupt();
		
		
		Runner two = new Runner();
		countThread = new Thread(two, "CountThreadqqqqq");
		countThread.start();
		
		two.cancel();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static class Runner implements Runnable{
		private long i;
		private volatile boolean on =true;
		@Override
		public void run() {
			System.out.println("current Thread Name:"+Thread.currentThread().getName());
			while (on &&!Thread.currentThread().isInterrupted()){
				i++;
			}
			System.out.println("Count i= "+i);
			System.out.println("current Thread Name:"+Thread.currentThread().getName());
			
		}
		public void cancel(){
			on=false;
			System.out.println("on=false");
		}
	}
}
