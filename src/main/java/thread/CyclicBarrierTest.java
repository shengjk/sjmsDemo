package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author shengjk1
 * @date 2020/11/4
 */
public class CyclicBarrierTest {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(20, () -> {
			System.out.println("满人发车");
		});
		
		for (int i = 0; i < 1000; i++) {
			new Thread(() -> {
				try {
					System.out.println(cyclicBarrier.getNumberWaiting());
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}
