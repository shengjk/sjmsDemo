package xmht.javabase.jsr305;


import javax.annotation.Nonnull;

/**
 * Created by shengjk1 on 2018/4/4
 */
public class Test {
	public static void main(String[] args) {
		test(null);
		String name ="a";
	}
	
	/*
	@Nullable
	 */
	public static void test(@Nonnull String a) {
		System.out.println(a.trim());
	}
	
}
