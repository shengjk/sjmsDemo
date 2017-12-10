package xmht.javabase.java4.classdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by shengjk1 on 2017/11/20
 */
interface Interface {
	void doSomething();
	
	void somethingElse(String arg);
}

class ReadObject implements Interface {
	@Override
	public void doSomething() {
		System.out.println("doSomething");
	}
	
	@Override
	public void somethingElse(String arg) {
		System.out.println("somethingElse " + arg);
	}
}

class SimpleProxy implements Interface {
	private Interface proxied;
	
	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}
	
	@Override
	public void doSomething() {
		System.out.println("SimpleProxy doSomething");
	}
	
	@Override
	public void somethingElse(String arg) {
		System.out.println("SimpleProxy  somethingElse");
		proxied.somethingElse(arg);
	}
}


class SimpleProxyDemo {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("booo");
	}
	
	public static void main(String[] args) {
//		consumer(new ReadObject());
		consumer(new SimpleProxy(new ReadObject()));
	}
}




class MethodSelector implements InvocationHandler{
	private Object proxied;
	
	public MethodSelector(Object proxied) {
		this.proxied = proxied;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().equals("interesting")){
			System.out.println("proxy detected the interesting method");
		}
		return method.invoke(proxied,args);
	}
}

interface SomeMethods{
	void boring1();
	void boring2();
	void interesting(String args);
	void boring3();
}

class Implementation implements SomeMethods{
	@Override
	public void boring1() {
		System.out.println("boring1");
	}
	
	@Override
	public void boring2() {
		System.out.println("boring2");
	}
	
	@Override
	public void interesting(String args) {
		System.out.println("interesting "+args);
	}
	
	@Override
	public void boring3() {
		System.out.println("boring3");
	}
}

class SelectingMethods{
	public static void main(String[] args) {
		SomeMethods proxy= (SomeMethods)Proxy.newProxyInstance(
				SomeMethods.class.getClassLoader(),
				new Class[]{SomeMethods.class},
				new MethodSelector(new Implementation()));
		proxy.boring1();
		proxy.boring2();
		proxy.boring3();
		proxy.interesting("bobobo");
	}
}


public class test {

}
