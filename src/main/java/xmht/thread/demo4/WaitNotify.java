package xmht.thread.demo4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author shengjk1
 * @date 2019/8/29
 */
public class WaitNotify {
	static boolean flag=true;
	static Object lock=new Object();
	
	public static void main(String[] args) {
		
		Thread waitThread = new Thread(new Wait(), "WaitThread");
		waitThread.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
//		synchronized (lock){
//			try {
//				TimeUnit.SECONDS.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		Thread notifyThread = new Thread(new Notify(), "notifyThread");
		notifyThread.start();
	}
	
	static class Wait implements Runnable{
		@Override
		public void run() {
			//加锁，拥有lock的Moitor
			synchronized (lock){
				while (flag){
					try {
						System.out.println(Thread.currentThread()+" flag is true. waitting@"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
						//执行wait之后会释放锁，然后进入休眠
						//当被唤醒后会自动重新获得锁
						//而sleep就是直接去睡觉不会释放锁
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread()+" flag is false. running@"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
		}
	}
	
	
	static class Notify implements Runnable{
		@Override
		public void run() {
			synchronized (lock){
				//获取lock的锁，然后进行通知，通知是不会释放lock的锁，
				//直到当前线程释放了 lock 后，WaitThread才能从 wait 方法中返回
				System.out.println(Thread.currentThread()+" hold lock. notify@"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
				/*
				使用 nofity() 会更加的高效。需要注意的是，nofity() 在某些情况下却会导致死锁，所以只有在经过精细地设计后，才能使用 nofity()。
				总的来讲，一开始应该总是使用 notifyAll()，只有在发现确实它导致性能问题时，才考虑 notify()，并且对死锁问题给予足够的关注。
				唤醒并一定真得能立刻唤醒，它需要等待线程重新获得该对象的 monitor
				 */
				flag=false;
				lock.notifyAll();
			}
			
			synchronized (lock){
				System.out.println(Thread.currentThread()+" hold lock. notify@"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
				try {
					//而sleep就是直接去睡觉不会释放锁
					//所以 lock.wait()想要 re-obtain ownership of the monitor and resumes execution
					// 必须等待 睡眠结束
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
