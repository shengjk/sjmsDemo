package xmht.structureModel.adapter;

/**
 * Created by shengjk1 on 2016/11/7.
 *
 *适配器模式将某一个类的接口转换成客户端期望的另一个接口表示，
 * 目的是消除由于接口不匹配所造成的类的兼容性问题。
 * 主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式
 *
 *
 *
 *类的适配器
 * 这样Targetable接口的实现类就具有了Source类的功能。
 */
public class Adapter extends Source implements Targetable {
	public void method2() {
		System.out.println("this is the targetable method!");
	}
}
