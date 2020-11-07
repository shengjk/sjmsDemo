package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shengjk1
 * @date 2020/11/2
 */
public class LockUseCase {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
		} finally {
			lock.unlock();
		}
		//用来构建锁或者其他同步组件的基础框架
//		AbstractQueuedSynchronizer
	}
	
	
}
