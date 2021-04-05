package xmht.datastructuresandalgorithms.msb.recursion;

/**
 * @author shengjk1
 * @date 2021/3/25
 */
public class Knapsack {

	public static int maxValue(int[] w, int[] v, int bag) {
		return process(w, v, 0, bag);
	}

	/*
	[0,index)已经计算完毕
	rest bag还剩多少重量
	 */
	public static int process(int[] weights, int[] values, int index, int rest) {
		if (rest < 0) {
			return -1;
		}
		if (rest == 0 || index == weights.length) {
			return 0;
		}

		//不包括 index
		int value1 = process(weights, values, index + 1, rest);
		//包括 index
		int value2 = process(weights, values, index + 1, rest - weights[index]);
		if (value2 != -1) {
			value2 += values[index];
		}

		return Math.max(value1, value2);
	}


	public static int dpWay(int[] weights, int[] values, int bag) {
		int N = weights.length;
		int[][] dp = new int[N + 1][bag + 1];

		for (int index = N - 1; index >= 0; index--) {
			for (int rest = 1; rest <= bag; rest++) {

				int p1 = dp[index + 1][rest];
				int p2 = -1;
				if (rest - weights[index] >= 0) {
					p2 = values[index] + dp[index + 1][rest - weights[index]];
				}
				dp[index][rest] = Math.max(p1, p2);
			}

		}
		return dp[0][bag];
	}

	public static void main(String[] args) {
		int[] weights = {3, 2, 4, 7};
		int[] values = {5, 6, 3, 19};
		int bag = 11;
		System.out.println(maxValue(weights, values, bag));
		System.out.println(dpWay(weights, values, bag));
	}

}
