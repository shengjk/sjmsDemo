package xmht.javabase;

/**
 * Created by shengjk1 on 2017/1/16.
 */

/*
被动引用
 */
public class SuperClass {
	static {
		System.out.println("SuperClass init!");
	}
	public static int value=123;
	public static final int value1=123;
	
	
	
	
}

class SubClass extends SuperClass{
	public static int value=1231;
	public static final int value1=1231;
	static {
		System.out.println("SubClass init!");
	}
}

class NotIninialization{
	public static void main(String[] args) {
		System.out.println(SubClass.value1);//JVM在进行字段解析时，是从下到上的
//		System.out.println(SuperClass.value1);
//		SuperClass[] sca=new SuperClass[10];
	}
}