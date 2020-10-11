package xmht.jvm;

/**
 * @author shengjk1
 * @date 2020/9/11
 */
public class FieldHasNoPolymorphic {
	//
	public static void main(String[] args) {
		Father son = new Son();
		System.out.println("son.memory = " + son.memory);
		son.showMeTheMoney();
	}
	
	static class Father {
		public int memory = 1;
		
		public Father() {
			memory = 2;
			showMeTheMoney();
		}
		
		public void showMeTheMoney() {
			System.out.println("father init memory " + memory);
		}
	}
	
	static class Son extends Father {
		public int memory = 3;
		
		public Son() {
			memory = 4;
			showMeTheMoney();
		}
		
		@Override
		public void showMeTheMoney() {
			System.out.println("son init memory " + memory);
		}
	}
}
