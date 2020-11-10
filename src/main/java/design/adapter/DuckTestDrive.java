package design.adapter;

/**
 * @author shengjk1
 * @date 2020/11/10
 */
public class DuckTestDrive {
	public static void main(String[] args) {
		MallardDuck mallardDuck = new MallardDuck();
		WildTurkey wildTurkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);
		System.out.println("The Turkey says...");
		wildTurkey.gobble();
		wildTurkey.fly();
		
		System.out.println("The Duck says...");
		
		testDuck(mallardDuck);
		// test 方法根本不知道这是一只火鸡
		testDuck(turkeyAdapter);
	}
	
	static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
}
