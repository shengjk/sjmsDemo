package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author shengjk1
 * @date 2020/11/4
 */
public class ThreadPoolExecutorTest {
	public static void main(String[] args) {
//		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		ExecutorService executorService1 = Executors.newSingleThreadExecutor();
		// 大小无界的线程池
		ExecutorService executorService2 = Executors.newCachedThreadPool();
		
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		
	}
}
