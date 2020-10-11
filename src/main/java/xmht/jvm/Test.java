package xmht.jvm;

/**
 * Created by shengjk1 on 2020/8/30.
 */
public class Test {
	public static int b;
	private int a;
	
	public static void main(String[] args) {
		Test test = new Test();
		test.test();
		System.out.println("b = " + b);
		System.out.println("执行完毕");
	}
	
	public void test() {
		byte i = 15;
		int j = 8;
		int k = i + j;
	}
}
