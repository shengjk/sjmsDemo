package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author shengjk1
 * @date 2020/11/4
 */
public class CountTask extends RecursiveTask<Integer> {
	private static final int THREAHOLD = 2;
	private int start;
	private int end;
	
	public CountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		CountTask task = new CountTask(1, 4);
		ForkJoinTask<Integer> result = forkJoinPool.submit(task);
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected Integer compute() {
		int sum = 0;
		boolean canCompute = (end - start) <= THREAHOLD;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			//如果任务大于阈值，就分裂成两个子任务计算
			int middle = (start + end) / 2;
			CountTask leftTask = new CountTask(start, middle);
			CountTask rightTask = new CountTask(middle + 1, end);
			
			//检查任务是否已经抛出异常或已经被取消了
			if (leftTask.isCompletedAbnormally()) {
				//如果任务被取消了，则返回 CancellationException
				//如果任务没有完成或者没有抛出异常返回 null
				System.out.println(leftTask.getException());
			}
			
			//执行子任务
			leftTask.fork();// ForkJoinWorkerThread pushTask 异步的执行
			rightTask.fork();
			//等待子任务执行完，并得到其结果
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			//合并子任务
			sum = leftResult + rightResult;
		}
		return sum;
	}
}
