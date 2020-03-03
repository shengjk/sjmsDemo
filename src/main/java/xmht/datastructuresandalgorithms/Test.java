package xmht.datastructuresandalgorithms;

import java.util.concurrent.TimeUnit;

/**
 * @author shengjk1
 * @date 2020/1/4
 */
public class Test {
	public static void main(String[] args) throws InterruptedException {
		int loopMax = 100000;
		
		long start = System.currentTimeMillis();
		String res = "";
		for (int i = 0; i < loopMax; i++) {
			res += i;
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start));
		System.out.println("res" + res);
		
		StringBuilder builder = new StringBuilder();
		start = System.currentTimeMillis();
		res = "";
		builder.append(res);
		for (int i = 0; i < loopMax; i++) {
			builder.append(i);
		}
		end = System.currentTimeMillis();
		System.out.println((end - start));
		System.out.println("bulider" + builder.toString());
		
		TimeUnit.SECONDS.sleep(1);
		
		
		start = System.currentTimeMillis();
		res = "";
		for (int i = 0; i < loopMax; i++) {
			StringBuilder builder1 = new StringBuilder();
			builder1.append(res);
			builder1.append(i);
			res = builder1.toString();
		}
		end = System.currentTimeMillis();
		System.out.println((end - start));
		System.out.println("new bulider" + res);
	}
}
