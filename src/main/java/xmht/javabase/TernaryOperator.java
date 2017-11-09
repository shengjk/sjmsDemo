package xmht.javabase;

public class TernaryOperator {
	
	/*
	若两个操作数都是直接量数字（Literal），则返回值类型为范围较大者。
知道是什么原因了，相应的解决办法也就有了：保证三元操作符中的两个操作数类型一致，即可减少可能错误的发生。
	 */
	public static void main(String[] args) {
		int i = 80;
		String s = String.valueOf(i < 100 ? 90 : 100);
		String s1 = String.valueOf(i < 100 ? 90 : 100.0);
		String s2 = String.valueOf(i < 100 ? "90" : 100.0);
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println("两者是否相等:" + s.equals(s1));
		System.out.println("两者是否相等:" + s.equals(s2));
	}
	
	/**
	 * 90
	 90.0
	 90
	 两者是否相等:false
	 两者是否相等:true
	 */
} 