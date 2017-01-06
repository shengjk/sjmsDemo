package xmht.decorator;

/**
 * Created by shengjk1 on 2016/11/7.
 *
 */
//被装饰的类
public class Source implements Sourceable {
	public void method() {
		System.out.println("the original method!");
	}
}
