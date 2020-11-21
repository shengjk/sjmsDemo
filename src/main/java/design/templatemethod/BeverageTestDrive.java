package design.templatemethod;

/**
 * @author shengjk1
 * @date 2020/11/11
 */
public class BeverageTestDrive {
	public static void main(String[] args) {
		CoffeeWithHook coffeeWithHook = new CoffeeWithHook();
		
		coffeeWithHook.prepareRecipe();
	}
}
