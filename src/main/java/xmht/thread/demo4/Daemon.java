package xmht.thread.demo4;

import java.util.concurrent.TimeUnit;

/**
 * @author shengjk1
 * @date 2019/8/27
 */
public class Daemon {
	public static void main(String[] args) {
		Thread daemonRunner = new Thread(new DaemonRunner(), "DaemonRunner");
		daemonRunner.setDaemon(true);
		daemonRunner.start();
		System.out.println("=====");
	}
	
	
	static class DaemonRunner implements Runnable{
		@Override
		public void run() {
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				//Daemon线程被用作完成支持工作，但是在Java虚拟机退出时Daemon线程中的finally块并不一定执行
				System.out.println("DaemonThread finally run.");
			}
		}
	}
}
