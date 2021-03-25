package xmht.datastructuresandalgorithms.msb.recursion;

/**
 * @author shengjk1
 * @date 2021/3/21
 */
public class ConvertToLetterString {

	/*
	[0...i) 已经处理完了，接下来只关心 i...chars.lenght
	 */
	public static int process(char[] chars, int i) {
		if (i == chars.length) {
			return 1;
		}
		if (chars[i] == '0') {
			return 0;
		}

		if (chars[i] == '1') {
			int res = process(chars, i + 1);
			if (i + 1 < chars.length) {
				res += process(chars, i + 2);
			}
			return res;
		}
		if (chars[i] == '2') {
			int res = process(chars, i + 1);
			if (i + 1 < chars.length && (chars[i + 1] >= '0' && chars[i + 1] <= 6)) {
				res += process(chars, i + 2);
			}
			return res;
		}
		//大于2 直接跳过
		return process(chars, i + 1);
	}
}
