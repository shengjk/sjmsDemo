package xmht.structureModel.adapter.objadapter;

import xmht.structureModel.adapter.classadapter.Source;
import xmht.structureModel.adapter.classadapter.Targetable;

/**
 * Created by shengjk1 on 2016/11/7.
 *
 *
 * 对象适配器
 * 基本思路和类的适配器模式相同，只是将Adapter类作修改，这次不继承Source类，
 * 而是持有Source类的实例，以达到解决兼容性的问题
 */
public class Wrapper implements Targetable{
	
	private Source source;
	
	public Wrapper(Source source) {
		super();
		this.source = source;
	}
	
	public void method1() {
		System.out.println("this is the targetable method!");
	}
	
	public void method2() {
		source.method1();
	}
}

class AdpaterTest{
	public static void main(String[] args) {
		Source source=new Source();
		Targetable targetable=new Wrapper(source);
		targetable.method1();
		targetable.method2();
	}
}
