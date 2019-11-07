package xmht.thread.demo5;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author shengjk1
 * @date 2019/9/3
 */
public class Mutex implements Lock {
	//静态内部类，自定义同步器
	private static class Sync extends AbstractQueuedSynchronizer {
		//独占式获取同步状态，实现该方法需要查询当前状态并判断同步状态是否符合预期，然后再进行CAS设置同步状态
		//当状态位0的时候获取锁
		@Override
		protected boolean tryAcquire(int arg) {
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}
		
		//释放锁，将状态设置为0
		@Override
		protected boolean tryRelease(int arg) {
			if (getState() == 0) {
				setExclusiveOwnerThread(null);
				setState(0);
				return true;
			}
			return super.tryRelease(arg);
		}
		
		/*
		当前同步器是否在独占模式下被线程占用，一般该方法表示是否被当前线程所独占
		 */
		@Override
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}
		
		Condition newCondition() {
			return new ConditionObject();
		}
	}
	
	//仅需要将操作代理到Sync上即可
	private final Sync sync = new Sync();
	
	@Override
	public void lock() {
		//对中断不敏感，也就说由于线程获取同步状态失败后进入同步队列中，后续对线程进行中断操作时，线程不会从同步队列中移出
		sync.acquire(1);
	}
	
	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}
	
	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}
	
	@Override
	public boolean tryLock(long time, @NotNull TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}
	
	@Override
	public void unlock() {
		sync.release(1);
	}
	
	@NotNull
	@Override
	public Condition newCondition() {
		return sync.newCondition();
	}
}
