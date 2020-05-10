package xmht.javabase.classinfofanshe;

/**
 * Created by shengjk1 on 2018/4/13
 */
class Base {
}

class Derived extends Base {
}

public class FamilyVsExactType {
	static void test(Object x) {
		System.out.println("Testing x of type" + x.getClass());
		System.out.println("x instance of Base " + (x instanceof Base));
		System.out.println("x instanceof Derived " + (x instanceof Derived));
		System.out.println("Base.class.isInstance(x) " + (x instanceof Base));
		System.out.println("Derived.class.isInstance(x) " + (x instanceof Derived));
		System.out.println(x.getClass() == Base.class);
		System.out.println(x.getClass() == Derived.class);
		System.out.println("========================");
		System.out.println(x.getClass().equals(Base.class));
		System.out.println(x.getClass().equals(Derived.class));
	}
	
	public static void main(String[] args) {
//		test(new Base());
		test(Base.class);
	}
	
}
