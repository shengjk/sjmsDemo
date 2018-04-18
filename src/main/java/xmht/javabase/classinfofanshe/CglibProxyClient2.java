package xmht.javabase.classinfofanshe;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by shengjk1 on 2018/4/18
 */

class AuthProxy2 implements MethodInterceptor {
	private String name ;
	//传入用户名称
	public AuthProxy2(String name){
		this.name = name;
	}
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
							MethodProxy arg3) throws Throwable {
		//用户进行判断
		if(!"张三".equals(name)){
			System.out.println("你没有权限！");
			return null;
		}
		return arg3.invokeSuper(arg0, arg2);
	}
}

class TableDAOFactory2 {
	private static TableDAO tDao = new TableDAO();
	public static TableDAO getInstance(){
		return tDao;
	}
	
	public static TableDAO getAuthInstance(AuthProxy2 authProxy){
		Enhancer en = new Enhancer();
		//进行代理
		en.setSuperclass(TableDAO.class);
		en.setCallback(authProxy);
		//生成代理实例
		return (TableDAO)en.create();
	}
}

public class CglibProxyClient2 {
	public static void main(String[] args) {
		TableDAO tableDao = TableDAOFactory2.getInstance();
//		doMethod(tableDao);
		haveAuth();
		haveNoAuth();
	}
	public static void doMethod(TableDAO dao){
		dao.create();
		dao.query();
		dao.update();
		dao.delete();
	}
	
	
	public static void haveAuth(){
		TableDAO tDao = TableDAOFactory2.getAuthInstance(new AuthProxy2("张三"));
		doMethod(tDao);
	}
	public static void haveNoAuth(){
		TableDAO tDao = TableDAOFactory2.getAuthInstance(new AuthProxy2("李四"));
		doMethod(tDao);
	}
	
}
