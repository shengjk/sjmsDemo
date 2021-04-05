package design.singleton;

/**
 * @author shengjk1
 * @date 2020/11/10
 * <p>
 * 线程安全的懒汉式（双重检查加锁
 */
public class Singleton1 {
	protected static Singleton1 uniqueInstance;

	private Singleton1() {
	}

	public static synchronized Singleton1 getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton1();
		}
		return uniqueInstance;
	}
}
