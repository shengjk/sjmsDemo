package xmht.javabase.classinfofanshe;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * Created by shengjk1 on 2018/4/18
 */

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

class TableDAOFactory3 {
	private static TableDAO tDao = new TableDAO();
	public static TableDAO getInstance(){
		return tDao;
	}
	
	public static TableDAO getAuthInstance(AuthProxy3 authProxy){
		Enhancer en = new Enhancer();
		//进行代理
		en.setSuperclass(TableDAO.class);
		en.setCallback(authProxy);
		//生成代理实例
		return (TableDAO)en.create();
	}
	
	
	public static TableDAO getAuthInstanceByFilter(AuthProxy3 authProxy){
		Enhancer en = new Enhancer();
		en.setSuperclass(TableDAO.class);
		en.setCallbacks(new Callback[]{authProxy, NoOp.INSTANCE});
		en.setCallbackFilter(new AuthProxyFilter());
		return (TableDAO)en.create();
	}
	
}


class AuthProxyFilter implements CallbackFilter {
	public int accept(Method arg0) {
		if(!"query".equalsIgnoreCase(arg0.getName())){
			System.out.println("=============== "+arg0.getName());
			return 0;
		}
		return 1;
	}
	
}



public class CglibProxyClient3 {
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
		TableDAO tDao = TableDAOFactory3.getAuthInstanceByFilter(new AuthProxy3("张三"));
		doMethod(tDao);
	}
	public static void haveNoAuth(){
		TableDAO tDao = TableDAOFactory3.getAuthInstanceByFilter(new AuthProxy3("李四"));
		doMethod(tDao);
	}
	
}
