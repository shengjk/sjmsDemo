package xmht.javabase.effictjava.chapter02.test02;

/**
 * @author shengjk1
 * @date 2019-05-13
 */
public class NutritionFacts {
	//私有属性在同一个class文件中具有全部的可见性，可以不通过set/get方法来进行直接访问
	private final int servingSize;
	private final int serving;
	private final int calories;
	private final int fat;
	private final int soaium;
	private final int carbohydrate;
	private static int size;
	
	/*
	内部类(静态内部类和成员内部类)都可以轻而易举的访问外部类的属性和方法
	还能轻而易举的访问自身的属性
	 */
	public static class Builder{
		private final int servingSize;
		private final int serving;
		
		private int calories = 0;
		private int fat = 0;
		private int carbohydrate = 0;
		private int sodium = 0;
		
		public Builder(int servingSize, int serving) {
			size++;
			test();
			this.servingSize = servingSize;
			this.serving = serving;
		}
		
		public Builder calories(int val){
			calories=val;
			return this;
		}
		
		public Builder fat(int val) {
			fat = val;
			return this;
		}
		
		public Builder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}
		
		public Builder sodium(int val) {
			sodium = val;
			return this;
		}
		
		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
		
	}
	
	
	private NutritionFacts(Builder builder){
		servingSize = builder.servingSize;
		serving = builder.serving;
		calories = builder.calories;
		fat = builder.fat;
		soaium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
	
	public static void test(){
		System.out.println("i am test");
	}
	
	
	public static void main(String[] args) {
		/*
		若有 static 修饰符，就为类级，否则为对象级。类级可以通过外部类直接访问，对象级需要先生成外部的对象后才能访问。
		 */
		NutritionFacts build = new Builder(240, 8).calories(100).build();
	}
	
	/*
	在方法中定义的内部类称为局部内部类。与局部变量类似，局部内部类不能有访问说明符，因为它不是外围类的一部分，但是它可以访问当前代码块内的常量，和此外围类所有的成员。
	 */
}
