package xmht.sjms.structureModel.decorator;

/**
 * Created by shengjk1 on 2016/11/7.
 *
 * 装饰模式 给一个对象增加一些新的功能，而且是动态的，
 * 要求装饰对象和被装饰对象实现同一个接口，
 * 装饰对象持有被装饰对象的实例
 *
 *
 *(不太理解)
 * 装饰器模式的应用场景：
 1、需要扩展一个类的功能。
 2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不能动态增删。）
 缺点：产生过多相似的对象，不易排错！
 *
 *
 */
//Decorator类是一个装饰类
public class Decorator implements Sourceable {
	
	private Sourceable source;
	
	public Decorator(Sourceable source) {
		this.source = source;
	}
	
	public void method() {
		System.out.println("before decorator!");
		source.method();
		System.out.println("after decorator!");
	}
}


class DecoratorTest{
	public static void main(String[] args) {
		Sourceable sourceable=new Source();
		Sourceable obj=new Decorator(sourceable);
		obj.method();
	}
}