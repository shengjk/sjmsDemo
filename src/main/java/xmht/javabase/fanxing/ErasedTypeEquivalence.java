package xmht.javabase.fanxing;

import java.util.ArrayList;

/**
 * Created by shengjk1 on 2018/4/23
 */
public class ErasedTypeEquivalence {
	public static void main(String[] args) {
		Class c1 = new ArrayList<String>().getClass();
		Class<? extends ArrayList> c2 = new ArrayList<Integer>().getClass();
		
		System.out.println(c1==c2);
	}
}
