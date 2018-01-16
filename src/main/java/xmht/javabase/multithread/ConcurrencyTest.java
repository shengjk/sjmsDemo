package xmht.javabase.multithread;

/**
 * Created by shengjk1 on 2017/12/20
 */
public class ConcurrencyTest {
	private static final long count = 100001;
	
	public static void main(String[] args) throws InterruptedException {
		concurrency();
		serial();
	}
	
	private static void concurrency() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				int a = 0;
				for (long i = 0; i < count; i++) {
					a += 5;
				}
				System.out.println(a);
			}
		});
		thread.start();
		int b = 0;
		for (long i = 0; i < count; i++) {
			b--;
		}
		long time = System.currentTimeMillis();
		thread.join();
		System.out.println("concurrency : " + time + " ms,b=" + b );
	}
	
	private static void serial() {
		long start = System.currentTimeMillis();
		int a = 0;
		for (long i = 0; i < count; i++) {
			a += 5;
		}
		int b = 0;
		for (long i = 0; i < count; i++) {
			b--;
		}
		long time= System.currentTimeMillis();
		System.out.println("serial : " + time + " ms,b=" + b);
	}
}
