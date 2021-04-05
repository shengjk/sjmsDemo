package design.singleton;

/**
 * @author shengjk1
 * @date 2021/3/29
 */
//静态内部类
public class Singleton3 {
	private static class SingletonHoler {
		private static Singleton3 instance = new Singleton3();
	}

	private Singleton3() {

	}

	public static Singleton3 getInstance() {
		return SingletonHoler.instance;
	}
}
