package thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author shengjk1
 * @date 2020/11/16
 */
public class LockSupportPrint {
	static Thread t1, t2;
	
	public static void main(String[] args) {
		char[] aI = "1234567".toCharArray();
		char[] aC = "ABCDEFG".toCharArray();
		
		t1 = new Thread(() -> {
			for (char c : aI) {
				System.out.println(c);
				LockSupport.unpark(t2);
				LockSupport.park(t1);
			}
		});
		
		t2 = new Thread(() -> {
			for (char c : aC) {
				LockSupport.park(t2);
				System.out.println(c);
				LockSupport.unpark(t1);
			}
		});
		
		t1.start();
		t2.start();
	}
}
