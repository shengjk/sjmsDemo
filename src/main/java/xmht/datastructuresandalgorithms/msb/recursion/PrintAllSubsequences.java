package xmht.datastructuresandalgorithms.msb.recursion;

import java.util.List;

/**
 * @author shengjk1
 * @date 2021/3/6
 * <p>
 * 字符串所有的子序列，可以不连续但相对顺序不能变
 */
public class PrintAllSubsequences {
	public static void main(String[] args) {

	}

	/*
	str 固定不变
	index 此时来到的位置，要 or 不要
	如果 index 来到了 str 终止位置，把沿途路径所形成的答案，放入ans 中
	 */
	public static void process(char[] str, int index, List<String> ans, String path) {
		if (index == str.length) {
			ans.add(path);
			return;
		}

		String no = path;
		process(str, index + 1, ans, no);

		String yes = path + String.valueOf(str[index]);
		process(str, index + 1, ans, yes);

	}
}
