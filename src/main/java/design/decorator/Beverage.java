package design.decorator;

/**
 * @author shengjk1
 * @date 2020/11/9
 */
public abstract class Beverage {
	String description = "unknown beverage";
	
	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
}
