package xmht.datastructuresandalgorithms.msb.recursion;

import java.util.ArrayList;

/**
 * @author shengjk1
 * @date 2021/3/6
 */
public class PrintAllPremutations {

	/*
	str[0...i-1] 已经做好决定了
	str[i...]都有机会来到 i 的位置
	i 终止位置，str 当前的样子，就是一种结果
	 */
	public static void process(char[] str, int index, ArrayList<String> ans) {
		if (index == str.length) {
			ans.add(String.valueOf(str));
		}

		//如果 i 没有终止，i... 都可以来到 i 位置
		for (int j = index; j < str.length; j++) {
			swap(str, index, j);
			process(str, index + 1, ans);
			swap(str, index, j);
		}
	}

	public static void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}

}
