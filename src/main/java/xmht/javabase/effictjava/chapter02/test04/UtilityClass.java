package xmht.javabase.effictjava.chapter02.test04;

public class UtilityClass {
	// Suppress default constructor for noninstantiability
	private UtilityClass() {
		//不是必须的，但它可以避免不小心在类的内部调用构造器
		throw new AssertionError();
	}
}
