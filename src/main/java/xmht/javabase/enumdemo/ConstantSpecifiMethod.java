package xmht.javabase.enumdemo;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by shengjk1 on 2018/4/24
 */

/*
实现常量相关的方法，你需要为enum定义一个或多个abstract方法，然后为每个enum实例实现该抽象方法
 */
public enum ConstantSpecifiMethod {
	DATA_TIME{
		@Override
		String getInfo(){
			return DateFormat.getDateInstance().format(new Date());
		}
	},
	CLASSPATH{
		@Override
	String getInfo(){
		return System.getenv("CLASSPATH");
	}
	},
	VERSION{
		@Override
		String getInfo(){
			return System.getProperty("java.version");
		}
	};
	
	abstract String getInfo();
	
	public static void main(String[] args) {
		System.out.println(ConstantSpecifiMethod.VERSION.getInfo());
		
	}
}
