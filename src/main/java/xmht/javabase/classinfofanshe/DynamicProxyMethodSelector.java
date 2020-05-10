package xmht.javabase.classinfofanshe;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by shengjk1 on 2018/4/16
 */
interface SomeMethods {
	void boring1();
	
	void boring2();
	
	void insteresting(String arg);
	
	void boring3();
}

class Implementation implements SomeMethods {
	@Override
	public void boring1() {
		System.out.println("boring1");
	}
	
	@Override
	public void boring2() {
		System.out.println("boring2");
	}
	
	@Override
	public void insteresting(String arg) {
		System.out.println("interesting" + arg);
	}
	
	@Override
	public void boring3() {
		System.out.println("boring3");
	}
}

public class DynamicProxyMethodSelector implements InvocationHandler {
	private final Object proxied;
	
	public DynamicProxyMethodSelector(Object proxied) {
		this.proxied = proxied;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().equalsIgnoreCase("insteresting")) {
			System.out.println("Proxy detected the interesting method");
		}
		return method.invoke(proxied, args);
	}
}


class SelectingMethods {
	public static void main(String[] args) {
		
		SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(),
				new Class[]{SomeMethods.class},
				new DynamicProxyMethodSelector(new Implementation()));
		
		proxy.boring1();
		proxy.insteresting("a");
	}
}