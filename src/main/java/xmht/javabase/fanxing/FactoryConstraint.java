package xmht.javabase.fanxing;

/**
 * Created by shengjk1 on 2018/4/23
 */

//解决类型擦除
interface FactoryI<T>{
	T create();
}
class Foo2<T>{
	private T x;
	public <F extends FactoryI<T>> Foo2(F factory){
		x=factory.create();
	}
}


class IntegerFactory implements FactoryI<Integer>{
	@Override
	public Integer create() {
		return new Integer(0);
	}
}

class Widget{
	public static class Factory implements FactoryI<Widget>{
		@Override
		public Widget create() {
			return new Widget();
		}
	}
}

public class FactoryConstraint {
	public static void main(String[] args) {
		//获得了编译器检查
		new Foo2<Integer>(new IntegerFactory());
		new Foo2<Widget>(new Widget.Factory());
	}
}









abstract class GenericWithCreate<T>{
	final T element;
	
	public GenericWithCreate() {
		this.element = create();
	}
	public abstract T create();
}
class X{}

class Creator extends GenericWithCreate<X>{
	@Override
	public X create() {
		return new X();
	}
	void f(){
		System.out.println(element.getClass().getSimpleName());
	}
	
	
	public static void main(String[] args) {
		Creator c = new Creator();
		c.f();
	}
}