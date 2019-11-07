package xmht.sjms.structureModel.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MainApp1 {
	public static void main(String[] args) {
		ClassLoader loader = MainApp1.class.getClassLoader();
		Class[] cs = {Waiter.class};
		Waiter target = new MyWaiter();
		MyInvocationHandler h = new MyInvocationHandler(target);
		Waiter waiter = (Waiter) Proxy.newProxyInstance(loader, cs, h);
		waiter.serve();
		
		
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTargetObject(target);
		Waiter waiter11 = (Waiter)proxyFactory.createProxy();
		System.out.println("proxyFactory======== ");
		waiter11.serve();
		
		
	}
}

class MyInvocationHandler implements InvocationHandler {
	public Waiter target;
	
	public MyInvocationHandler(Waiter target) {
		this.target = target;
	}
	
	@Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("您好！");
		Object result = method.invoke(target, args);
		System.out.println("很高兴为您服务！");
		return result;
	}
}