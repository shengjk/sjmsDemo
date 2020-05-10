package xmht.javabase.classinfofanshe;

/**
 * Created by shengjk1 on 2018/4/13
 */

/**
 * 代理模式可以在不修改被代理对象的基础上，通过扩展代理类，进行一些功能的附加与增强。值得注意的是，代理类和被代理类应该公同实现一个接口，或者共同继承某个类
 * 静态代理
 */
interface Interface {
	void doSomething();
	
	void somethingElse(String arg);
}

class RealObject implements Interface {
	
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
	private final Interface proxied;
	
	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}
	
	@Override
	public void doSomething() {
		System.out.println("SimpleProxy doSomething");
		proxied.doSomething();
		
	}
	
	@Override
	public void somethingElse(String arg) {
		System.out.println("SimpleProxy somethingElse " + arg);
		proxied.somethingElse(arg);
	}
}

public class SimpleStaticProxyDemo {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	
	public static void main(String[] args) {
//		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
//		new SimpleProxy(new RealObject()).doSomething();
//		new SimpleProxy(new RealObject()).somethingElse("aaa");
	}
}
