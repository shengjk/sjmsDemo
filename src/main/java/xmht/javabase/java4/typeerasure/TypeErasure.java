package xmht.javabase.java4.typeerasure;

import java.util.ArrayList;

/**
 * Created by shengjk1 on 2018/2/12
 */
public class TypeErasure {
	public static void main(String[] args) {
		Class c1=new ArrayList<String>().getClass();
		Class c2=new ArrayList<Integer>().getClass();
		System.out.println(c1==c2);
		System.out.println(c1.isInstance(c2));
	}
}
