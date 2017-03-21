package xmht.sjms.createModel.prototype;

/**
 * Created by shengjk1 on 2017/1/9.
 */

/*
很简单，一个原型类，只需要实现Cloneable接口，覆写clone方法，此处clone方法可以改成任意的名称，因为Cloneable接口是个空接口，你可以任意定义实现类的方法名，如cloneA或者cloneB，因为此处的重点是super.clone()这句话，super.clone()调用的是Object的clone()方法，而在Object类中，clone()是native的
 */
public class Prototype1 implements Cloneable {
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Prototype1 prototype=(Prototype1)super.clone();
		return prototype;
	}
}
