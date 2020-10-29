package xmht.zsda.handwriting.one;

/**
 * @author shengjk1
 * @date 2020/10/20
 */
//异或 无进位相加
// 0^N=N N^N=0
public class XOR {
	public static void main(String[] args) {
		Integer c = 1, a = 1, b = 1;
		System.out.println(a == c);
		System.out.println(a == b);
		System.out.println(c == b);
		
		//不申请额外变量交换啊a,b 的值
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(a == c);
		System.out.println(a == b);
		System.out.println(c == b);
		
		String s1 = "hello,world!";
		String s2 = "hello,world!";
		System.out.println(s1 == s2);
		
		System.out.println("========");
		int i1 = 1000;
		int i2 = 1000;
		int i3 = 100;
		int i4 = 100;
		
		System.out.println(i1 == i2);
		System.out.println(i3 == i4);
		
		System.out.println("+++++++++++++");
		
		Integer i5 = 1000, i6 = 1000, i7 = 100, i8 = 100;
		System.out.println(i5 == i6);
		System.out.println(i7 == i8);
	}
	
	// N&(~N+1) 取 N 最右侧的 1
	
}
