package xmht.javabase.fanxing;

/**
 * Created by shengjk1 on 2018/4/23
 */
public class ThreeTuple<A, B, C> extends TuoTuple<A, B> {
	public final C third;
	
	public ThreeTuple(A first, B second, C third) {
		super(first, second);
		this.third = third;
	}
	
	@Override
	public String toString() {
		return "("+first+","+second+","+third;
	}
}
