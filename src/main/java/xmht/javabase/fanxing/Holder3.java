package xmht.javabase.fanxing;

/**
 * Created by shengjk1 on 2018/4/23
 */
class AutoMobile{}
public class Holder3<T> {
	private T a;
	
	public Holder3(T a) {
		this.a = a;
	}
	
	public T getA() {
		return a;
	}
	
	public void setA(T a) {
		this.a = a;
	}
	
	public static void main(String[] args) {
		Holder3<AutoMobile> h3=new Holder3<>(new AutoMobile());
	}
}
