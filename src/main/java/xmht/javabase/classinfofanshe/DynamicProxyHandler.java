package xmht.javabase.classinfofanshe;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by shengjk1 on 2018/4/13
 */

/*
java动态代理可以避免静态代理带来的代码冗余的问题
java 的动态代理只能针对接口创建代理，不能针对类创建代理

java的动态代理的真实对象必须实现接口

用途：
Spring AOP就是使用的动态代理方式。在Hibernate和Spring这两种框架里，在AOP，权限控制，事务管理等方面都有动态代理的实现
dubbo消费者初始化的时候生成代理，也是使用的动态代理。
hibernate的懒加载。
 */

interface Interface2 {
	void doSomething();
	
	void somethingElse(String arg);
}

class RealObject2 implements Interface2 {
	
	@Override
	public void doSomething() {
		System.out.println("doSomething");
	}
	
	@Override
	public void somethingElse(String arg) {
		System.out.println("somethingElse " + arg);
	}
}


public class DynamicProxyHandler implements InvocationHandler {
	private final Object proxied;
	
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	
	public <T> T getProxy() {
		return (T) Proxy.newProxyInstance(
				proxied.getClass().getClassLoader(),
				proxied.getClass().getInterfaces(),
				this);
	}
	
	
	@Override
	/*
	proxy真实对象，method我们调用真实对象的方法，args要调用真实对象方法时接受的参数
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(" proxy: " + proxy.getClass() + ", method: " + method + ",args: " + args);
		System.out.println("========= " + proxy.getClass().getInterfaces());
		if (args != null) {
			for (Object arg : args) {
				System.out.println(" " + arg);
			}
		}
		/*
		执行被代理的操作，然后使用Method.invoke()将请求转发给代理对象，并传入必须参数
		 */
		return method.invoke(proxied, args);
	}
}

class SimpleDynamicProxy {
	//动态代理可以将所有调用重定向到调用处理器，因此通常会向调用处理器的构造器传递给一个"实际"对象的引用，从而使得调用处理器在执行其中介任务时，可以将请求转发
	public static void consumer(Interface2 ifac) {
		ifac.doSomething();//当调用方法的时候，才开始调用InvocationHandler的实现
		ifac.somethingElse("bonobo");
	}
	
	public static void main(String[] args) {
		RealObject2 realObject = new RealObject2();
//		consumer(realObject);
		
		//insert a proxy and call again
		//通常可以从已知被加载的对象中获取其类加载器，然后传递给它
		Interface2 proxy = (Interface2) Proxy.newProxyInstance(Interface2.class.getClassLoader(),
				new Class[]{Interface2.class},//该代理实现的接口列表
				new DynamicProxyHandler(realObject));//InvocationHandler接口的一个实现
		consumer(proxy);
//		Interface proxy = new DynamicProxyHandler(realObject).getProxy();
//		proxy.somethingElse("bonobo");
//		proxy.doSomething();
	}
}