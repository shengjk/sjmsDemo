package xmht.sjms.createModel.singleton;

import java.util.Vector;

/**
 * Created by shengjk1 on 2017/1/6.
 */
/*
影子实例  不明白有什么用，从代码中看到是为了同步属性的
 */
public class Singleton2 {
	private static Singleton2 singleton2=null;
	/*
vector与arraylist类似，只不过vector线程安全而arraylist线程不安全
	 */
	private Vector properties=null;
	
	public Vector getProperties(){
		return properties;
	}
	
	private Singleton2(){}
	
	private static synchronized void syscInit(){
		if(singleton2==null){
			singleton2=new Singleton2();
		}
	}
	
	public static Singleton2 getSingleton2(){
		if (singleton2==null){
			syscInit();
		}
		return  singleton2;
	}
	
	public void updateProperties(){
		Singleton2 shadow=new Singleton2();
		properties=shadow.getProperties();
	}
}
