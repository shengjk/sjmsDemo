package xmht.datastructuresandalgorithms.msb.recursion;

/**
 * @author shengjk1
 * @date 2021/3/9
 */
public class NQueens {

	public static int num1(int n) {
		if (n < 1) {
			return 0;
		}
//record[i] -> i行的皇后，放在了第几列
		int[] record = new int[n];
		return process(0, record, n);
	}

	/*
	潜台词 record[0...i-1]皇后，任何两个皇后一定都不共行，不共列，不共斜线
	目前来到了第 i 行
	record[0...i-1]表示之前的行，放了皇后的位置
	n 代表整体一共多少行 0~n-1 行
	返回值，摆完所有皇后合理摆法
	 */
	public static int process(int i, int[] record, int n) {
		if (i == n) {
			return 1;
		}

		int res = 0;
		for (int j = 0; j < n; j++) {
			if (isValid(record, i, j)) {
				//该皇后摆在了第 i 行 第 j 列
				record[i] = j;
				res += process(i + 1, record, n);
			}
		}
		return res;
	}

	//record[0...i-1]需要看，record[i...]不需要看，因为[i...]并未放皇后
	//返回 i 行皇后，放在了 j 列，是否有效
	public static boolean isValid(int[] record, int i, int j) {
		for (int k = 0; k < i; k++) {
			if (record[k] == j || Math.abs(record[k] - j) == Math.abs(k - i)) {
				return false;
			}
		}
		return true;
	}
}
