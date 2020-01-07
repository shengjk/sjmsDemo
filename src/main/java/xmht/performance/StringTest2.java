package xmht.performance;

/**
 * @author shengjk1
 * @date 2019/9/24
 */
/*
+ 比 concat 快
a.indexOf("a") 比 a.indexOf(97) 快
 */
public class StringTest2 {
	public static void func(int a) {
		a = 20;
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		
		String a = "a";
		
		String b = "b";
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) { //ten million times
			String c = a.concat(b);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		//快
		for (int i = 0; i < 10000000; i++) { //ten million times
			String c = a + b;
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - end);
		
		a="bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbba";
		 start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) { //ten million times
			a.indexOf(97);
		}
		 end = System.currentTimeMillis();
		System.out.println(end - start);
		//快
		for (int i = 0; i < 10000000; i++) { //ten million times
			a.indexOf("a");
		}
		 end1 = System.currentTimeMillis();
		System.out.println(end1 - end);
		System.out.println(a.intern());
	}
}
