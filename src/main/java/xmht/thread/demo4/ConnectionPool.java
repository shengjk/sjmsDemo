package xmht.thread.demo4;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author shengjk1
 * @date 2019/9/2
 */
public class ConnectionPool {
	private LinkedList<Connection> pool=new LinkedList<Connection>();
	
	public ConnectionPool(int initialSize) {
		if (initialSize>0){
			for (int i = 0; i < initialSize; i++) {
				pool.addLast(ConnectionDriver.createConnection());
			}
		}
	}
	
	public void releaseConnection(Connection connection){
		if (connection!=null){
			synchronized (pool){
				pool.addLast(connection);
				pool.notifyAll();
			}
		}
	}
	
	public Connection fetchConnection(long mills) throws InterruptedException{
		synchronized (pool){
			if (mills<=0){
				while (pool.isEmpty()){
					pool.wait();
				}
				return pool.removeFirst();
			}else{
				long future=System.currentTimeMillis()+mills;
				long remaining=mills;
				
				while (pool.isEmpty() && remaining>0){
					//会被其他thread唤醒
					pool.wait(remaining);
					remaining=future-System.currentTimeMillis();
				}
				Connection result=null;
				if (!pool.isEmpty()){
					result=pool.removeFirst();
				}
				return result;
			}
		}
	}
}
