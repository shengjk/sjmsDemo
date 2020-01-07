package xmht.concurrency.thread.demo4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @author shengjk1
 * @date 2019/9/2
 */
public class ConnectionDriver {
	static class ConnectionHandler implements InvocationHandler{
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if(method.getName().equals("commit")){
				TimeUnit.MILLISECONDS.sleep(1000);
			}
			return null;
		}
	}
	public static final Connection createConnection(){
		Connection connection = (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class[]{Connection.class},
				new ConnectionHandler());
		return connection;
	}
}
