package xmht.thread.demo4;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shengjk1
 * @date 2019/9/3
 */
public class ConnectionPoolTest {
	static ConnectionPool pool = new ConnectionPool(10);
	//保证所有的 ConnectionRunner能够同时开始
	static CountDownLatch start = new CountDownLatch(1);
	//main线程将会等待所有ConnectionRunner结束后才能够继续执行
	static CountDownLatch end;
	
	public static void main(String[] args) throws InterruptedException {
		int threadCount = 100;
		end = new CountDownLatch(threadCount);
		int count = 200;
		AtomicInteger got = new AtomicInteger();
		AtomicInteger notGot = new AtomicInteger();
		for (int i = 0; i < threadCount; i++) {
			Thread connectionRunnerThread = new Thread(new ConnetionRunner(count, got, notGot), "ConnectionRunnerThread");
			connectionRunnerThread.start();
		}
		start.countDown();
		end.await();
		System.out.println("total invoke: "+(threadCount * count));
		System.out.println("got connection: "+got);
		System.out.println("not got connection: "+notGot);
	}
	
	static class ConnetionRunner implements Runnable {
		int count;
		AtomicInteger got;
		AtomicInteger notGot;
		
		public ConnetionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
			this.count = count;
			this.got = got;
			this.notGot = notGot;
		}
		
		@Override
		public void run() {
			try {
				start.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while (count > 0) {
				try {
					//从线程池中获取连接，如果1000ms内无法获取到，将会返回null，分别统计连接获取的数量got和未获取到的数量notGot
					//按时返回，并且告知客户端连接获取出现问题，是系统的一种自我保护机制。
					Connection connection = pool.fetchConnection(1000);
					if (connection != null) {
						try {
							connection.createStatement();
							connection.commit();
						} finally {
							pool.releaseConnection(connection);
							got.incrementAndGet();
						}
					} else {
						notGot.incrementAndGet();
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					count--;
				}
			}
			end.countDown();
		}
	}
}
