package xmht.javabase.classinfofanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Created by shengjk1 on 2018/4/13
 */
/*
展示所有的方法，包括构造器
public static void main(String[]) throws ClassNotFoundException
public final void wait(long,int) throws InterruptedException
public final native void wait(long) throws InterruptedException
public final void wait() throws InterruptedException
public boolean equals(Object)
public String toString()
public native int hashCode()
public final native Class getClass()
public final native void notify()
public final native void notifyAll()
public ShowMethods()
只能展示public的方法

 */
public class ShowMethods {
	//去掉命名修饰词
	private static Pattern pattern = Pattern.compile("\\w+\\.");
	
	protected static void test(){}
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		int lines = 0;
		
		Class<?> c = Class.forName("xmht.javabase.classinfofanshe.ShowMethods");
		Method[] methods = c.getMethods();
		Constructor<?>[] constructors = c.getConstructors();
		for (Method me : methods) {
			System.out.println(pattern.matcher(me.toString()).replaceAll(""));
//			System.out.println(me.toString());
		}
		for (Constructor con :constructors) {
			System.out.println(pattern.matcher(con.toString()).replaceAll(""));
//			System.out.println(con.toString());
		}
	}
}
