import java.util.ArrayList;

/**
 * @author shengjk1
 * @date 2019-07-09
 */
public class Test1 {
	public static void main(String[] args) {
		short i = 10;
		//虽然编译器会自动帮助我们进行扩展，但需要更多的机器指令，执行的时间会更长
		int a = i + 10;
		System.out.println(a);
		System.out.println((byte) ((int) (Math.pow(2, 9) + Math.pow(2, 7))));
		
		int b = 1 >> 1;
		System.out.println(b);
		
		float fa = 9.0F;
		int i1 = (int) fa;
		System.out.println(i1);
		System.out.println(Float.floatToRawIntBits(0.9f));
		System.out.println(Float.floatToRawIntBits(9.0f));
		int aa = 9;
		
		System.out.println((float) aa);
		
		double d = 0.2 + 0.4;
		System.out.println(" 0.2 + 0.4 " + d);
		float df = 0.2f + 0.4f;
		System.out.println(" 0.2 + 0.4 " + df);
		
		System.out.println(Long.toBinaryString(Double.doubleToLongBits(0.4d)));
		System.out.println(Long.toBinaryString(Double.doubleToLongBits(0.2d)));
		System.out.println(Long.toBinaryString(Double.doubleToLongBits(0.2 + 0.4d)));
		
		
		System.out.println(Long.toBinaryString(Float.floatToRawIntBits(0.2f + 0.4f)));
		System.out.println(Long.toBinaryString(Float.floatToIntBits(0.2f + 0.4f)));
		
		
		//总之只要他们不是被计算出来的，可以比较。
		double d1 = 0.1711111111111113, d2 = 0.1711111111111113;
		System.out.println(d1 == d2);// 坏代码
		System.out.println(Double.compare(d1, d2) == 0);// 好代码
		System.out.println(Double.doubleToLongBits(d1) == Double.doubleToLongBits(d2));// 好代码
		System.out.println(Double.valueOf(d1).equals(d2));// 好代码，1.5以上
		
		double result = 1.0 - 0.9;
		System.out.println(result);
		System.out.println("=================");
		System.out.println(0.1 + 0.2 == 0.3);
		
		ArrayList<String> strings = new ArrayList<>();
		strings.isEmpty();
		
		"".split("#", -1);
		
		while (true) {
			long aaa = 900000000;
			long start = System.currentTimeMillis();
			for (int j = 0; j < aaa; j++) {
				if (100 > 10) {
				
				}
			}
			System.out.println(System.currentTimeMillis() - start);
			
			start = System.currentTimeMillis();
			for (int j = 0; j < aaa; j++) {
				if (100 == 10) {
				
				}
			}
			System.out.println(System.currentTimeMillis() - start);
			System.out.println("============");
		}
		
		
	}
}
