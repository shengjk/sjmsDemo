package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author shengjk1
 * @date 2020/11/2
 */
public class DoubleCheck {
	static volatile DoubleCheck INSTANCE;
	
	public DoubleCheck() {
	}
	
	public static DoubleCheck getInstance() {
		if (INSTANCE == null) {
			synchronized (DoubleCheck.class) {
				if (INSTANCE == null) {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					INSTANCE = new DoubleCheck();
				}
			}
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				System.out.println(DoubleCheck.getInstance().hashCode());
			}).start();
		}
		CountDownLatch latch = new CountDownLatch(10);
	}
}
