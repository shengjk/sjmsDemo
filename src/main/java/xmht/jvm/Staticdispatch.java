package xmht.jvm;

public class Staticdispatch {
	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		
		Staticdispatch staticdispatch = new Staticdispatch();
		staticdispatch.sayhello(man);
		staticdispatch.sayhello(woman);
		
		man.sayHi();
		woman.sayHi();
	}
	
	public void sayhello(Human guy) {
		System.out.println("hello guy");
	}
	
	public void sayhello(Man guy) {
		System.out.println("hello Man");
	}
	
	public void sayhello(Woman guy) {
		System.out.println("hello Woman");
	}
	
	static abstract class Human {
		protected abstract void sayHi();
	}
	
	static class Man extends Human {
		@Override
		protected void sayHi() {
			System.out.println("man say hi");
		}
	}
	
	static class Woman extends Human {
		@Override
		protected void sayHi() {
			System.out.println("Woman say hi");
		}
	}
}
