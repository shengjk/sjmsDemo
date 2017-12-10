package xmht.javabase.java4.classdemo;

/**
 * Created by shengjk1 on 2017/11/21
 */
class Base{}
class Derived extends Base{}
public class FamilyVsExacType {
	static void test(Object x){
		System.out.println(x.getClass());
		System.out.println(x instanceof Base);
		System.out.println(x instanceof Derived);
		System.out.println(x.getClass()==Base.class);
		System.out.println(x.getClass()==Derived.class);
		System.out.println(x.getClass().equals(Base.class));
		System.out.println(x.getClass().equals(Derived.class));
	}
	
	public static void main(String[] args) {
		test(new Derived());
	}
}
