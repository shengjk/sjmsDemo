package design.adapter;

/**
 * @author shengjk1
 * @date 2020/11/10
 */
public class MallardDuck implements Duck {
	@Override
	public void quack() {
		System.out.println("quack");
		
	}
	
	@Override
	public void fly() {
		System.out.println("i am flying");
	}
}
