package xmht.zsda.handwriting;

/**
 * @author shengjk1
 * @date 2020/11/12
 */
public class BigDataSum {
	public static void main(String[] args) {
		String str1 = "123456789";
		String str2 = "123";
		
		System.out.println(add(str1, str2));
	}
	
	public static String add(String s1, String s2) {
		if (s1 == null || s1.length() == 0) {
			return s2;
		}
		
		if (s2 == null || s2.length() == 0) {
			return s1;
		}
		
		int maxLenght = Math.max(s1.length(), s2.length());
		//定义一个存储结果的字符串，长度要比最长长度还长一位，防止进位
		StringBuffer result = new StringBuffer(maxLenght + 1);
		
		s1 = new StringBuffer(s1).reverse().toString();
		s2 = new StringBuffer(s2).reverse().toString();
		
		int minLength = Math.min(s1.length(), s2.length());
		//进位
		int carry = 0;
		//当前位上的数值
		int currentNum = 0;
		
		int i = 0;
		for (; i < minLength; i++) {
			//分别获得两个字符对应的字面数值，然后相加，再加上进位
			currentNum = s1.charAt(i) + s2.charAt(i) - 2 * '0' + carry;
			//获取进位
			carry = currentNum / 10;
			currentNum %= 10;
			result.append(String.valueOf(currentNum));
		}
		
		if (s1.length() < s2.length()) {
			s1 = s2;
		}
		
		for (; i < s1.length(); i++) {
			currentNum = s1.charAt(i) - '0' + carry;
			carry = currentNum / 10;
			currentNum %= 10;
			result.append(String.valueOf(currentNum));
		}
		//最后处理进位
		if (carry > 0) {
			result.append(String.valueOf(carry));
		}
		return result.reverse().toString();
	}
}
