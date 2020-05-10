package xmht.javabase.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by shengjk1 on 2018/4/11
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {
	String value();
}

@ExtractInterface("IMultiplier")
class Multiplier {
	public static void main(String[] args) {
		Multiplier multiplier = new Multiplier();
		System.out.println(multiplier.multiplier(11, 16));
	}
	
	public int multiplier(int x, int y) {
		int total = 0;
		for (int i = 0; i < x; i++) {
			total = add(total, y);
		}
		return total;
	}
	
	private int add(int x, int y) {
		return x + y;
	}
}

/*
看一下官方关于java8的APT升级说明：

可以看到以前所有的类都移到 javax.annotation.processing and javax.lang.model包中了。
未找到AnnotationProcessor类  java
/
 */
//class InterfaceExtractorProcessor implements AnnotationProcessor{
//
//}