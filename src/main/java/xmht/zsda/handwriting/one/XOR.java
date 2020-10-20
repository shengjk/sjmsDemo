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
		
		
	}
	
}
