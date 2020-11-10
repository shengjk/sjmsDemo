package design.singleton;

/**
 * @author shengjk1
 * @date 2020/11/10
 */
public class Singleton {
	protected static Singleton uniqueInstance;
	
	private Singleton() {
	}
	
	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
}
