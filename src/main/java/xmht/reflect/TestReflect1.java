package xmht.reflect;

import java.io.Serializable;

/**
 * Created by shengjk1 on 2017/4/27 0027
 */
//实例化Class对象/获取父类、获取接口
public class TestReflect1 implements Serializable {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> class1 = null;
		Class<?> class2 = null;
		Class<?> class3 = null;
		
		class1 = Class.forName("reflect.TestReflect1");
		class2 = new TestReflect1().getClass();
		class3 = TestReflect1.class;
		System.out.println(class1.getName());
//		获取父类
		
		System.out.println(class2.getSuperclass().getName());
		
		Class<?>[] intes = Class.forName("reflect.TestReflect1").getInterfaces();
		for (int i = 0; i < intes.length; i++) {
			System.out.println(intes[i].getName());
		}
	}
}
