package xmht.thread.demo5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shengjk1
 * @date 2019/9/3
 */
public class LockUseCase {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
		}finally {
			lock.unlock();
		}
		
	}
}
