package xmht.concurrency.thread.demo4;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shengjk1
 * @date 2019/8/26
 */
public class ReentrantLockExample {
	int a=0;
	ReentrantLock lock=new ReentrantLock();
	public void writer(){
		lock.lock();
		try {
			a++;
		} finally {
			lock.unlock();
		}
	}
	
	public void reader(){
		lock.lock();
		try {
			int i=a;
		} finally {
			lock.unlock();
		}
	}
}
