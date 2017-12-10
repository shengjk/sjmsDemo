package xmht.javabase.java4.classdemo;

import java.util.Random;

/**
 * Created by shengjk1 on 2017/11/20
 */
class Initable{
	static final int staticFinal=47;
	static final int staticFinal2=ClassInitialization.random.nextInt(1000);
	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2{
	static int staticNonFinal=147;
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3{
	static int staticNonFinal=74;
	static {
		System.out.println("Initializing Initable3");
	}
}


public class ClassInitialization {
	public static Random random=new Random(47);
	
	public static void main(String[] args) throws Exception {
		Class initable=Initable.class;
		System.out.println(initable.getName());
		System.out.println(initable.getClassLoader());
		System.out.println(Initable.staticFinal);
//		System.out.println(Initable.staticFinal2);
		Class<?>  intClass=int.class;
		System.out.println(intClass.getClassLoader());
		intClass=double.class;
		System.out.println(intClass.getClassLoader());
		
		Class<? extends Number> bounded=int.class;
		bounded=double.class;
		bounded=Number.class;
//		Class.forName("xmht.javabase.java4.classdemo.Initable");
	}
}
