package design.decorator;

/**
 * @author shengjk1
 * @date 2020/11/9
 */
public class DarkRoast extends Beverage {
	public DarkRoast() {
		this.description = "Dark Roast Coffe";
	}
	
	@Override
	public double cost() {
		return .99;
	}
}
