package xmht.javabase.classinfofanshe;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by shengjk1 on 2018/4/18
 */
/*
cglib (Code Generation Library )是一个第三方代码生成类库，运行时在内存中动态生成一个子类对象从而实现对目标对象功能的扩展。

cglib特点

JDK的动态代理有一个限制，就是使用动态代理的对象必须实现一个或多个接口。
如果想代理没有实现接口的类，就可以使用CGLIB实现。
CGLIB是一个强大的高性能的代码生成包，它可以在运行期扩展Java类与实现Java接口。
它广泛的被许多AOP的框架使用，例如Spring AOP和dynaop，为他们提供方法的interception（拦截）。
CGLIB包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。
不鼓励直接使用ASM，因为它需要你对JVM内部结构包括class文件的格式和指令集都很熟悉。
cglib与动态代理最大的区别就是

使用动态代理的对象必须实现一个或多个接口
使用cglib代理的对象则无需实现接口，达到代理类无侵入。









静态代理实现较简单，只要代理对象对目标对象进行包装，即可实现增强功能，但静态代理只能为一个目标对象服务，如果目标对象过多，则会产生很多代理类。
JDK动态代理需要目标对象实现业务接口，代理类只需实现InvocationHandler接口。
动态代理生成的类为 lass com.sun.proxy.$Proxy4，cglib代理生成的类为class com.cglib.UserDao$$EnhancerByCGLIB$$552188b6。
静态代理在编译时产生class字节码文件，可以直接使用，效率高。
动态代理必须实现InvocationHandler接口，通过反射代理方法，比较消耗系统性能，但可以减少代理类的数量，使用更灵活。
cglib代理无需实现接口，通过生成类字节码实现代理，比反射稍快，不存在性能问题，但cglib会继承目标对象，需要重写方法，所以目标对象不能为final类。


 */

//目标对象
class UserDao{
	public void save(){
		System.out.println("保存数据");
	}
}

//代理对象
public class CglibProxyHandler implements MethodInterceptor{
	private Object target;//维护一个目标对象
	
	public CglibProxyHandler(Object target) {
		this.target = target;
	}
	
	//为目标对象生成代理对象
	public Object getProxyInstance(){
		//工具类
		Enhancer enhancer = new Enhancer();
		//设置父类
		enhancer.setSuperclass(target.getClass());
		//设置回调函数
		enhancer.setCallback(this);
		//创建子类对象代理
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("开启事务");
		//执行目标对象的方法
		Object returnValve = method.invoke(target, args);
		System.out.println("关闭事务");
		return null;
	}
	
	
	public static void main(String[] args) {
		//目标对象
		UserDao target = new UserDao();
		System.out.println(target.getClass());
		//代理对象
		UserDao proxy = (UserDao) new CglibProxyHandler(target).getProxyInstance();
		System.out.println(proxy.getClass());
		//执行代理对象方法
		proxy.save();
	}
}
