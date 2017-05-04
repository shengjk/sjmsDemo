package xmht.reflect;

/**
 * Created by shengjk1 on 2017/4/27 0027
 */
public class TestReflect {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		TestReflect testReflect=new TestReflect();
		System.out.println(testReflect.getClass().getName());
		System.out.println(testReflect.getClass().getClassLoader());
		System.out.println(testReflect.getClass().getConstructors());
		System.out.println(testReflect.getClass().newInstance().getClass().getClassLoader());
		System.out.println(testReflect.getClass());
	}
}
