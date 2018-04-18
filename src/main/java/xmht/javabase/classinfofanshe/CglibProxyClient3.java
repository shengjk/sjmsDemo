package xmht.javabase.classinfofanshe;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * Created by shengjk1 on 2018/4/18
 */
//实际对象
class TableDAO3 {
	public void create(){
		System.out.println("create() is running !");
	}
	public void query(){
		System.out.println("query() is running !");
	}
	public void update(){
		System.out.println("update() is running !");
	}
	public void delete(){
		System.out.println("delete() is running !");
	}
}


class AuthProxy3 implements MethodInterceptor {
	private String name ;
	//传入用户名称
	public AuthProxy3(String name){
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

class AuthProxyFilter implements CallbackFilter {
	@Override
	//0或者1是取en.setCallbacks中的new Callback[]{}的值
	public int accept(Method arg0) {
		if(!"query".equalsIgnoreCase(arg0.getName())){
//			System.out.println("=============== "+arg0.getName());
			return 0;
		}
		return 1;
	}
	
}


class TableDAOFactory3 {
	private static TableDAO3 tDao = new TableDAO3();
	public static TableDAO3 getInstance(){
		return tDao;
	}
	
	public static TableDAO3 getAuthInstance(AuthProxy3 authProxy){
		Enhancer en = new Enhancer();
		//进行代理
		en.setSuperclass(TableDAO3.class);
		en.setCallback(authProxy);
		//生成代理实例
		return (TableDAO3)en.create();
	}
	
	
	public static TableDAO3 getAuthInstanceByFilter(AuthProxy3 authProxy){
		Enhancer en = new Enhancer();
		en.setSuperclass(TableDAO3.class);
		en.setCallbacks(new Callback[]{authProxy, NoOp.INSTANCE});
		en.setCallbackFilter(new AuthProxyFilter());
		return (TableDAO3)en.create();
	}
	
}


public class CglibProxyClient3 {
	public static void main(String[] args) {
		TableDAO3 tableDao = TableDAOFactory3.getInstance();
//		doMethod(tableDao);
		haveAuth();
		haveNoAuth();
	}
	public static void doMethod(TableDAO3 dao){
		dao.create();
		dao.query();
		dao.update();
		dao.delete();
	}
	
	
	public static void haveAuth(){
		TableDAO3 tDao = TableDAOFactory3.getAuthInstanceByFilter(new AuthProxy3("张三"));
		doMethod(tDao);
	}
	public static void haveNoAuth(){
		TableDAO3 tDao = TableDAOFactory3.getAuthInstanceByFilter(new AuthProxy3("李四"));
		doMethod(tDao);
	}
	
}
