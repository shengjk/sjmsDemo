package design.decorator;

/**
 * @author shengjk1
 * @date 2020/11/9
 */
public class Moca extends CondimentDecorator {
	public Moca(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.description + ",Moca";
	}
	
	@Override
	public double cost() {
		return 0.99 + beverage.cost();
	}
}
