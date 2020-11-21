package design.templatemethod;

/**
 * @author shengjk1
 * @date 2020/11/11
 */
public class CoffeeWithHook extends CaffeineBeverageWithHook {
	@Override
	void brew() {
		System.out.println("Dripping Coffee through filter");
	}
	
	@Override
	void addCondiments() {
		System.out.println("Adding sugar and Milk");
	}
	
	@Override
	boolean customeWantsCondiments() {
		String answer = getUserInput();
		if (answer.toLowerCase().startsWith("y")) {
			return true;
		} else {
			return false;
		}
	}
	
	private String getUserInput() {
		return "y";
	}
}
