package xmht.concurrency.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author shengjk1
 * @date 2020/7/7
 */
public class Test {
	public static void main(String[] args) throws Exception {
		// 执行器 避免频繁的创建线程销毁线程
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.submit(() -> {
			System.out.println("hello->" + Thread.currentThread().getName());
		});
		
		executorService.shutdown();
		
		
		// Callable 与 Runnable 类似，只是 Callable 有返回值
		Callable<Integer> task = () -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};
		System.out.println("task.call() = " + task.call());
		
		//Callable 也可以像 Runnable 一样，作为入参，提交给 executor
		ExecutorService ex = Executors.newFixedThreadPool(1);
		Future<Integer> future = ex.submit(task);
		System.out.println("future.isDone() = " + future.isDone());
		//会阻塞，等待返回结果
		System.out.println("future.get() = " + future.get());
		System.out.println("future.isDone() = " + future.isDone());
		
		
		// future timeout
		Future<?> future1 = ex.submit(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		});
//		future1.get(1, TimeUnit.SECONDS);
		ex.shutdown();
		
		
		// invokeAll
		// 一次性批量提交多个 callable。这个方法的结果是一个 future 集合
		ExecutorService executorService1 = Executors.newWorkStealingPool();
		List<Callable<String>> callables = Arrays.asList(
				() -> "task1",
				() -> "task2",
				() -> "task3"
		);
		executorService1.invokeAll(callables).stream().map(f -> {
			try {
				return f.get();
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}).forEach(System.out::println);
		
		executorService1.shutdown();
		
		
		// invokeAny
		//同样是批量提交，与 invokeAll 不同点在于 invokeAny 会阻塞等待，但当存在第一个执行完成的 callable，它huilike返回执行结果，
		//不再等待那些正在执行中的 callable 了。
		ExecutorService executorService2 = Executors.newWorkStealingPool();
		List<Callable<String>> callables2 = Arrays.asList(
				callable("task1", 2),
				callable("task2", 1),
				callable("task3", 3));
		
		String result = executorService2.invokeAny(callables);
		System.out.println("result = " + result);
		
		
		//ScheduledExecutorService 支持任务调度、持续执行或者延迟执行
		//scheduleWithFixedDelay() 和 scheduleAtFixedRate() 最大的区别就是，scheduleWithFixedDelay()需要等到前一个任务执行完成后才开始计延时，再触发下一个任务。
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		Runnable task3 = () -> System.out.println("scheduling:" + System.nanoTime());
		ScheduledFuture<?> scheduledFuture = scheduledExecutorService.schedule(task3, 3, TimeUnit.SECONDS);
		TimeUnit.MILLISECONDS.sleep(1337);
		// 用来获取距离目标时间的时间差，也就是剩余的延迟时间
		long remainingDelay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
		System.out.println("remainingDelay = " + remainingDelay);
		scheduledExecutorService.shutdown();
	}
	
	static Callable<String> callable(String result, long sleepSeconds) {
		return () -> {
			TimeUnit.SECONDS.sleep(sleepSeconds);
			return result;
		};
	}
}
