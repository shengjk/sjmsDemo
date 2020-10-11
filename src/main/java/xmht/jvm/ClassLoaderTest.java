package xmht.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author shengjk1
 * @date 2020/9/8
 */
public class ClassLoaderTest {
	public static int a = 10;
	
	static {
		System.out.println("ClassLoaderTest init=======");
	}
	
	private int b = 10;
	
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		ClassLoader myClassLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if (is == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		};
		Object obj = myClassLoader.loadClass("xmht.jvm.ClassLoaderTest").newInstance();
		System.out.println(obj.getClass());
		System.out.println((obj));
		System.out.println(obj instanceof ClassLoaderTest);
		
		ClassLoaderTest classLoaderTest = new ClassLoaderTest();
		classLoaderTest.test();
		getClassLoaderTest();
	}
	
	public static void getClassLoaderTest() {
		System.out.println(a);
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println(systemClassLoader.getClass());
		System.out.println("ClassLoader.getSystemClassLoader().getParent().getClass() = " + ClassLoader.getSystemClassLoader().getParent().getClass());
//		System.out.println("ClassLoader.getSystemClassLoader().getParent().getParent().getClass() = " + ClassLoader.getSystemClassLoader().getParent().getParent().getClass());
	}
	
	public void test() {
		System.out.println(a);
		System.out.println(b);
		System.out.println("test=========");
	}
}
