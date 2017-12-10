package xmht.javabase.java4.classdemo;

import java.lang.reflect.Constructor;
import java.util.regex.Pattern;

/**
 * Created by shengjk1 on 2017/11/21
 */
public class ShowMethods {
	private static String usage="aaaaaaaaaa";
	private static Pattern p=Pattern.compile("\\w+\\.");
	
	public static void main(String[] args) {
		int lines=0;
		try {
			Class<?> c=Class.forName("xmht.javabase.java4.classdemo.ShowMethods");
			Constructor[] ctors=c.getConstructors();
			System.out.println(ctors[0]);
		}catch (Exception e){
		
		}
	}
}
