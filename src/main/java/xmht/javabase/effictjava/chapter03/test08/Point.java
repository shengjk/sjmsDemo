package xmht.javabase.effictjava.chapter03.test08;

import java.util.Objects;

/**
 * @author shengjk1
 * @date 2019-05-15
 */
public  class Point {
	private final int x;
	private final int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Point)){
			return false;
		}
		System.out.println("aaaaaaaaaaaaaaa");
		Point p=(Point)o;
		return p.x==x && p.y==y;
	}
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(x, y);
//	}
	//延迟初始化
	
	private volatile int hashCode;
	@Override
	public int hashCode() {
		int result=hashCode;
		if (result==0){
			result=Objects.hash(x, y);
		}
		return result;
	}
}
