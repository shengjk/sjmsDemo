package xmht.javabase;

/*
会先进行对象的实例初始化，如果有必要的话，然后才会调用构造器进行对象的初始化

实例变量： 对象分配内存空间后默认赋值-->实例变量初始化器中赋值 -->实例初始化器中赋值
--> 类的构造函数中赋值

 */
public class InstanceInitializer {
	private int i = 1;
	private final int j = getI();
	private final int j1 = i + 1;//实例变量初始化器
	
	{
		i = 12;//实例初始化器
	}
	
	public InstanceInitializer() {
		i = 2;
	}
	
	public static void main(String[] args) {
		InstanceInitializer ii = new InstanceInitializer();
		System.out.println(ii.j);
		System.out.println(ii.i);
	}
	
	private int getI() {
		return i;
	}
}