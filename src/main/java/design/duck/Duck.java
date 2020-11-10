package design.duck;

/**
 * @author shengjk1
 * @date 2020/11/9
 */
public abstract class Duck {
	private FlyBehavior flyBehavior;
	private QuackBehavior quackBehavior;
	
	public static final void test() {
		System.out.println("test");
	}
	
	public abstract void display();
}
