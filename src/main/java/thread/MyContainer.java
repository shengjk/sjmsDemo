package thread;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shengjk1
 * @date 2020/11/4
 */
// 实现一个阻塞队列
public class MyContainer<T> {
	final private LinkedList<T> lists = new LinkedList<>();
	final private int MAX = 100;
	
	private Lock lock = new ReentrantLock();
	private Condition producer = lock.newCondition();
	private Condition consumer = lock.newCondition();
	
	public static void main(String[] args) {
		MyContainer<String> c = new MyContainer<>();
		//启动消费者线程
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				for (int j = 0; j < 50; j++) {
					System.out.println(c.get());
				}
				;
			}, "c" + i).start();
		}
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		//启动生产者线程
		for (int i = 0; i < 2; i++) {
			new Thread(() -> {
				for (int j = 0; j < 250; j++) c.put(Thread.currentThread().getName() + " " + j);
			}, "p" + i).start();
		}
	}
	
	public void put(T t) {
		lock.lock();
		try {
			while (lists.size() == MAX) {
				producer.await();
			}
			lists.add(t);
			//通知所有消费者消费
			consumer.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public T get() {
		T t = null;
		lock.lock();
		try {
			while (lists.size() == 0) {
				consumer.await();
			}
			t = lists.removeFirst();
			producer.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return t;
	}
}
