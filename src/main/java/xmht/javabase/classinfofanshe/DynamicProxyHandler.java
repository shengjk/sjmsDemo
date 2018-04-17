package xmht.javabase.classinfofanshe;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by shengjk1 on 2018/4/13
 */
public class DynamicProxyHandler implements InvocationHandler{
	private Object proxied;
	
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	
	@Override
	/*
	proxy实际对象的代理，method代理执行器当前所执行的方法，args当前所执行的方法传递的参数
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(" proxy: "+proxy.getClass() +", method: "+method+",args: "+args);
		if (args!=null){
			for (Object arg:args) {
				System.out.println(" "+arg);
			}
		}
		return method.invoke(proxied,args);
	}
}

class SimpleDynamicProxy{
	//动态代理可以将所有调用重定向到调用处理器，因此通常会向调用处理器的构造器传递给一个"实际"对象的引用，从而使得调用处理器在执行其中介任务时，可以将请求转发
	public static void consumer(Interface ifac){
		ifac.doSomething();//当调用方法的时候，才开始调用InvocationHandler的实现
		ifac.somethingElse("bonobo");
	}
	
	public static void main(String[] args) {
		RealObject realObject=new RealObject();
//		consumer(realObject);
		
		//insert a proxy and call again
		//通常可以从已知被加载的对象中获取其类加载器，然后传递给它
		Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
				new Class[]{Interface.class},//该代理实现的接口列表
				new DynamicProxyHandler(realObject));//InvocationHandler接口的一个实现
		consumer(proxy);
//		proxy.somethingElse("bonobo");
//		proxy.doSomething();
	}
}