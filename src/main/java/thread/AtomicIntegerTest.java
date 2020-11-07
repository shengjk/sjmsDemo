package thread;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shengjk1
 * @date 2020/11/3
 */
public class AtomicIntegerTest {
	AtomicInteger count = new AtomicInteger(0);
	
	public static void main(String[] args) {
		AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
		ArrayList<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(atomicIntegerTest::m, "thread-" + i));
		}
		threads.forEach((o) -> o.start());
		
		threads.forEach((o) -> {
			try {
				o.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println(atomicIntegerTest.count);
	}
	
	void m() {
		for (int i = 0; i < 10000; i++) {
			count.incrementAndGet();
		}
	}
}
