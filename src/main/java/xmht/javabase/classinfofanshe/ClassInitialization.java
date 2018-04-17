package xmht.javabase.classinfofanshe;

import java.util.Random;

/**
 * Created by shengjk1 on 2018/4/13
 */
class Initable{
	static final int staticFinal=47;
	static final int staticFinal2=ClassInitialization.random.nextInt(1000);
	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2{
	static int staticNonnFInal=147;
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3{
	static int i;
	static {
		System.out.println("Initializing Initable3");
		i=10;
	}
	static int staticNonnFInal=74;
}

public class ClassInitialization {
	public static Random random=new Random(0);
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class<Initable> initableClass = Initable.class;
//		System.out.println("====================");
//		System.out.println(Initable.staticFinal);
//		System.out.println(Initable.staticFinal2);
//		System.out.println("====================");
//		System.out.println(Initable2.staticNonnFInal);
		System.out.println(Initable3.i);
//		System.out.println(Initable3.staticNonnFInal);
//		System.out.println("====================");
//		Class<?> aClass = Class.forName("xmht.javabase.classinfo.Initable3");
		
		Class<? extends Number> bounded=int.class;
		Class<? super Integer> bounded1=int.class;
	}
}
