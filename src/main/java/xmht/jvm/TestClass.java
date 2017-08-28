package xmht.jvm;

/**
 * Created by shengjk1 on 2017/8/21
 */
public class TestClass {
	private int m;
	public int inc(){
		return m+1;
	}
	static {
		i=0;
	}
	static int i=10;
	
	
	public static void main(String[] args) {
		System.out.println(TestClass.i);
	}
}

 class Parent{
	public static int A=1;
	static {
		A=2;
	}
}
class Sub extends Parent{
	static int A=12;
}
