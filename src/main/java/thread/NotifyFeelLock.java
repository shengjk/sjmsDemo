package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author shengjk1
 * @date 2020/11/4
 */
public class NotifyFeelLock {
	//添加volatile，使t2能够得到通知
	volatile List lists = new ArrayList();
	
	public static void main(String[] args) {
		Thread t2 = new Thread(() -> {
			System.out.println("t2 启动");
			try {
				Thread.currentThread().wait();
				Thread.currentThread().notify();
			} catch (InterruptedException e) {
			}
			System.out.println("t2 停止");
		});
		t2.start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void add(Object o) {
		lists.add(o);
	}
	
	public int size() {
		return lists.size();
	}
}
