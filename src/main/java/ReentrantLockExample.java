import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shengjk1
 * @date 2020/9/22
 */
public class ReentrantLockExample {
	int a = 0;
	ReentrantLock lock = new ReentrantLock();
	
	public void writer() {
		lock.lock();
		try {
			a++;
		} finally {
			lock.unlock();
		}
	}
	
	public void reader() {
		lock.lock();
		try {
			int i = a;
		} finally {
			lock.unlock();
		}
	}
}
