package design.singleton;

/**
 * @author shengjk1
 * @date 2020/11/10
 */
public class Singleton2 {
	//饿汉式
	protected static Singleton2 uniqueInstance = new Singleton2();

	private Singleton2() {
	}

	public static Singleton2 getInstance() {
		return uniqueInstance;
	}
}
