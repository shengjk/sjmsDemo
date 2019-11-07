package xmht.javabase.effictjava.chapter04.test17;

import java.util.Date;

/**
 * @author shengjk1
 * @date 2019-06-26
 */
public final class Sub  extends Super{
	private final Date date;
	
	 Sub() {
		this.date = new Date();
	}
	
	@Override
	public void overridMe() {
		System.out.println(date);
	}
	
	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.overridMe();
	}
}
