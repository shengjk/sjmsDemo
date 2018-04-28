package xmht.javabase.fanxing;

/**
 * Created by shengjk1 on 2018/4/23
 */
public class TuoTuple<A,B> {
	public final A first;
	public final B second;
	
	public TuoTuple(A first, B second) {
		this.first = first;
		this.second = second;
	}
	
	@Override
	public String toString() {
		return "("+first+","+second;
	}
	
	public static void main(String[] args) {
	}
}
