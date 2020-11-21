package thread;

/**
 * @author shengjk1
 * @date 2020/11/16
 */
public class SyncWaitNotify {
	public static void main(String[] args) {
		Object o = new Object();
		
		char[] aI = "1234567".toCharArray();
		char[] aC = "ABCDEFG".toCharArray();
		
		new Thread(() -> {
			synchronized (o) {
				for (char c : aI) {
					System.out.println(c);
					
					try {
						o.notify();
						o.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				o.notify();
			}
		}, "t1").start();
		
		new Thread(() -> {
			synchronized (o) {
				for (char c : aC) {
					System.out.println(c);
					
					try {
						o.notify();
						o.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				o.notify();
			}
		}, "t1").start();
	}
}
