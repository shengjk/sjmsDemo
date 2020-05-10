package xmht;

/**
 * @author shengjk1
 * @date 2020/2/29
 */
public class Test {
	public static void main(String[] args) {
		System.out.println(null instanceof String);
		System.out.println(null instanceof Object);
		
		String constantString = "interned Baeldung";
		String newString = "interned Baeldung";
		
		System.out.println(constantString == newString);
		
		String internedString = newString.intern();
		System.out.println(constantString == internedString);
	}
}
