package xmht.reflect;

/**
 * Created by shengjk1 on 2018/4/12
 */
class Candy{
	static {
		System.out.println("loading candy");
	}
}

class Gum{
	static {
		System.out.println("loading gum");
	}
}

class Cookie{
	static {
		System.out.println("loading cookie");
	}
}



class Cookie1{
	static final int A=1;
	static {
		System.out.println("loading cookie1");
	}
}


public class SweetShop {
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		System.out.println("inside main");
		new Candy();
//		Class.forName("xmht.reflect.Gum");
		System.out.println(Gum.class.getSuperclass());
		Cookie cookie = new Cookie();//更多的是对象内存的引用，而非对象的引用
		Class<? extends Cookie> aClass = cookie.getClass();//才是真正对象的引用
		//对象的引用与对象内存的引用完全是两码事，对象内存的引用更偏向于物理层面也就是内存层面的东西，而对象引用更多的偏向于获得对象本身的一些信息
		Cookie cookie1 = aClass.newInstance();
		Cookie cookie2 = cookie.getClass().newInstance();
		System.out.println(Integer.class.getSuperclass());//class java.lang.Number
		System.out.println(Integer.TYPE);//int
		System.out.println(Integer.class);//class java.lang.Integer
		System.out.println(int.class.getSuperclass());//null
		System.out.println(int.class);//int
		System.out.println(Cookie1.A);
		
	}
}
