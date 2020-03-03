package xmht.javabase.java4;

public interface TestInterface {
	//隐式的 static final
	int Value = 5;
	
	//隐式的 public
	void abstractmethod();
	
	default void defaultMethod() {
	
	}
	
	static void staticMethod() {
	
	}
}
