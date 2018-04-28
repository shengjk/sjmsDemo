package xmht.javabase.fanxing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shengjk1 on 2018/4/23
 */
public class GenericMethods {
	public  <T> String f(T x){
		System.out.println(x.getClass().getName());
		return "aa";
	}
	
	public static void main(String[] args) {
		GenericMethods genericMethods=new GenericMethods();
		System.out.println(genericMethods.f("a"));
	}
	
	public static <K,V> Map<K,V> map(){
		return new HashMap<>();
	}
}
