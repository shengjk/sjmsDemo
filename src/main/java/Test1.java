/**
 * Created by shengjk1 on 2018/4/27
 */
public class Test1 {
	public static void main(String[] args) {
		System.out.println(System.getProperty("sun.reflect.inflationThreshold"));
//		test(3);
		
	}
	
	public static void test(int i) {
		Class c = null;
		
		if (c == null && i != 0) {
			try {
				i--;
				test(i);
			} catch (Exception e) {
				System.out.println(i);
				
			}
			
			
			if (c == null) {
				throw new RuntimeException(new ClassNotFoundException("a"));
			}
		} else {
			System.out.println("=========== " + i);
		}
	}
}
