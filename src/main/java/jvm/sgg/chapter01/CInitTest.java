package jvm.sgg.chapter01;

/**
 * @author shengjk1
 * @date 2020/4/26
 */
public class CInitTest {
	private static int c = 3;

	static {
		System.out.println(c);
		c = 12;
	}
	
	private int a = 1;
	
	public CInitTest() {
		a = 10;
		int d = 20;
	}
	
	public static void main(String[] args) {
		int b = 2;
	}
}
