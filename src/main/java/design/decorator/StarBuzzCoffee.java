package design.decorator;

/**
 * @author shengjk1
 * @date 2020/11/9
 */
public class StarBuzzCoffee {
	public static void main(String[] args) {
		Beverage beverage = new DarkRoast();
		beverage = new Moca(beverage);
		System.out.println(beverage.getDescription() + " $" + beverage.cost());
	}
}
