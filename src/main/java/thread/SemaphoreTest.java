package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author shengjk1
 * @date 2020/11/4
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(2);
		
		new Thread(() -> {
			try {
				semaphore.acquire();
				System.out.println("T1 running....");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("T1 running....");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaphore.release();
			}
		}).start();
	}
}
