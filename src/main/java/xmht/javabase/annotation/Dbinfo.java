package xmht.javabase.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;

/**
 * Created by shengjk1 on 2018/4/13
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Dbinfo {
	String url();
	
	String driverName();
	
	String userName();
	
	String passWord();
}

class SayHello {
	
	@Dbinfo(url = "jdbc:mysql://localhost:3306/example?useUnicode=true&characterEncoding=UTF-8",
			driverName = "com.mysql.jdbc.Driver",
			userName = "root",
			passWord = "12345678")
	public Connection getCon(String url, String drivername, String username, String password) throws Exception {
		Class.forName(drivername).newInstance();
		System.out.println(drivername);
		Connection con = null;
		//if(url!=null&&username!=null&&password!=null){
		con = DriverManager.getConnection(url, username, password);
		System.out.println(con);
		//}
		return con;
	}
	
}

class ParseAnnotation {
	public static void parseMethod(Class clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		Object obj = clazz.newInstance();
		Method[] methods = clazz.getDeclaredMethods();
		
		for (Method m : methods) {
			Dbinfo db = m.getAnnotation(Dbinfo.class);
			m.getReturnType();
			String url = "";
			String drivername = "";
			String username = "";
			String password = "";
			if (db != null) {
				url = db.url();
				drivername = db.driverName();
				username = db.userName();
				password = db.passWord();
//				m.invoke(obj, url,drivername,username,password);
				Connection con = (Connection) m.invoke(obj, url, drivername, username, password);
				PreparedStatement preparedStatement = con.prepareStatement("select * from test1");
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					System.out.println(resultSet.getObject(1));
				}
				con.close();
			}
		}
		
	}
	
	public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, SQLException, IllegalAccessException {
		parseMethod(SayHello.class);
	}
}