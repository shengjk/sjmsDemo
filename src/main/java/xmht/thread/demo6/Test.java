package xmht.thread.demo6;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.BiConsumer;

/**
 * @author shengjk1
 * @date 2019/9/11
 */
public class Test {
	public static void main(String[] args) throws InterruptedException {
		HashMap<String, String> map = new HashMap<>(2);
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(),"");
						}
					},"ftf"+i).start();
				}
			}
		},"ftf");
		t.start();
		t.join();
		
		map.forEach((BiConsumer<String,String>)(x,y)->{
			System.out.println(x+" ============= "+y);
		});
	}
}
