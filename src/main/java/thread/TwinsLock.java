package thread;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author shengjk1
 * @date 2020/11/2
 */
public class TwinsLock implements Lock {
	private final Sync sync = new Sync(2);
	
	@NotNull
	@Override
	public Condition newCondition() {
		return null;
	}
	
	@Override
	public void lock() {
	
	}
	
	@Override
	public void lockInterruptibly() throws InterruptedException {
	
	}
	
	@Override
	public boolean tryLock() {
		return false;
	}
	
	@Override
	public boolean tryLock(long time, @NotNull TimeUnit unit) throws InterruptedException {
		return false;
	}
	
	@Override
	public void unlock() {
	
	}
	
	private static final class Sync extends AbstractQueuedSynchronizer {
		public Sync(int count) {
			if (count <= 0) {
				throw new IllegalArgumentException("count must large than zero");
			}
			setState(count);
		}
		
		@Override
		public int tryAcquireShared(int reduceCount) {
			for (; ; ) {
				int current = getState();
				int newCount = current - reduceCount;
				if (newCount < 0 || compareAndSetState(current, newCount)) {
					return newCount;
				}
			}
		}
		
		@Override
		public boolean tryReleaseShared(int returnCount) {
			for (; ; ) {
				int current = getState();
				int newCount = current + returnCount;
				if (compareAndSetState(current, newCount)) {
					return true;
				}
			}
		}
	}
	
}
