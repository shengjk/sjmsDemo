package xmht.concurrency.thread.demo4;

import java.util.concurrent.TimeUnit;

/**
 * @author shengjk1
 * @date 2019/8/27
 */
public class Interrupted {
	public static void main(String[] args) throws InterruptedException {
		Thread sleepThread = new Thread(new SleepRuuner(), "SleepThread");
		sleepThread.setDaemon(true);
		
		Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
		busyThread.setDaemon(true);
		
		sleepThread.start();
		busyThread.start();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sleepThread.interrupt();
		busyThread.interrupt();
		
//		sleepThread.join();
//		Thread.interrupted();
		System.out.println("sleepThread interrupted is "+sleepThread.isInterrupted());
		System.out.println("busyThread interrupted is "+busyThread.isInterrupted());
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("sleepThread interrupted is "+sleepThread.isInterrupted());
		System.out.println("busyThread interrupted is "+busyThread.isInterrupted());
	}
	
	
	static class SleepRuuner implements Runnable{
		@Override
		public void run() {
			while (true){
				System.out.println("SleepRuuner");
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
//					错误
//					Thread.currentThread().interrupt();
					
					e.printStackTrace();
				}
				
			}
		}
	}
	
	static class BusyRunner implements Runnable{
		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted() && true){
				System.out.println("BusyRunner");
				
				try {
					TimeUnit.SECONDS.sleep(100000);
				} catch (InterruptedException e) {
//					错误
//					Thread.currentThread().interrupt();
					
					e.printStackTrace();
				}
			}
			boolean interrupted = Thread.currentThread().isInterrupted();
			System.out.println("BusyRunner interrupted "+interrupted);
		}
	}
}
