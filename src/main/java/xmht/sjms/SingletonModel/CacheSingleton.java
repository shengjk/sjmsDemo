package xmht.sjms.SingletonModel;

/**
 * Created by shengjk1 on 2018/4/20
 */

//待定
public enum CacheSingleton {
	INSTANCE;
	
	private String a;
	
	CacheSingleton() {
		System.out.println("初始化缓存变量");
		this.a="1";
	}
	
	public String getA(){
		return a;
	}
}
