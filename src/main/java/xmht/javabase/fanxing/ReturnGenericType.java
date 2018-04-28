package xmht.javabase.fanxing;

/**
 * Created by shengjk1 on 2018/4/23
 */
class HasF{}
public class ReturnGenericType <T extends HasF>{
	private T obj;
	
	public ReturnGenericType(T obj) {
		this.obj = obj;
	}
	public T get(){
		return obj;
	}
}
