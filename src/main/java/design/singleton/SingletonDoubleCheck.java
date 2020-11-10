package design.singleton;

/**
 * @author shengjk1
 * @date 2020/11/10
 */
public class SingletonDoubleCheck {
	protected static volatile SingletonDoubleCheck uniqueInstance;
	
	private SingletonDoubleCheck() {
	}
	
	public static SingletonDoubleCheck getInstance() {
		if (uniqueInstance == null) {
			synchronized (SingletonDoubleCheck.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new SingletonDoubleCheck();
				}
			}
		}
		return uniqueInstance;
	}
}
