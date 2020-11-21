package design.templatemethod;

/**
 * @author shengjk1
 * @date 2020/11/11
 */
public abstract class CaffeineBeverageWithHook {
	
	//模板方法
	void prepareRecipe() {
		boilWater();
		//我在用这个方法，但这个方法的具体是有子类实现的
		brew();
		pourInCup();
		if (customeWantsCondiments()) {
			addCondiments();
		}
	}
	
	abstract void brew();
	
	abstract void addCondiments();
	
	void boilWater() {
		System.out.println("Boiling water");
	}
	
	void pourInCup() {
		System.out.println("Pourng into cup");
	}
	
	// 这是一个钩子，可以改变算法步骤的轨迹
	boolean customeWantsCondiments() {
		return true;
	}
}
