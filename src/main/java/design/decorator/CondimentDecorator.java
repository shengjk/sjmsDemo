package design.decorator;

/**
 * @author shengjk1
 * @date 2020/11/9
 */
//饮料
public abstract class CondimentDecorator extends Beverage {
	Beverage beverage;
	
	@Override
	public abstract String getDescription();
}
