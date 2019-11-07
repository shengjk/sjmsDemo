package xmht.thread.demo4;

import java.util.concurrent.TimeUnit;

/**
 * @author shengjk1
 * @date 2019/8/27
 */
public class Interrupted {
	public static void main(String[] args) {
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
		
		System.out.println("sleepThread interrupted is "+sleepThread.isInterrupted());
		System.out.println("busyThread interrupted is "+busyThread.isInterrupted());
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	static class SleepRuuner implements Runnable{
		@Override
		public void run() {
			while (true){
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	static class BusyRunner implements Runnable{
		@Override
		public void run() {
			while (true){
			
			}
		}
	}
}
