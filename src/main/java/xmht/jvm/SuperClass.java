package xmht.jvm;

/**
 * @author shengjk1
 * @date 2020/9/7
 */


public interface SuperClass {
	public static int value = 0;
}

class SubClass implements SuperClass {
	public static int value = 1;
	
	static {
		System.out.println("subClass init");
	}
}

class NotInitialization {
	public static void main(String[] args) {
		System.out.println(SubClass.value);
//		SuperClass[] superClasses = new SuperClass[10];
	}
}