package xmht.datastructuresandalgorithms.msb.recursion;

/**
 * @author shengjk1
 * @date 2021/3/31
 * <p>
 * 爬楼梯的最小消耗
 */
public class MinCost {
	public static void main(String[] args) {
		int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		int[] dp = new int[arr.length + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println(process1(arr, arr.length, dp));
		System.out.println(process(arr, arr.length));
		System.out.println(processdp(arr));
	}


	/*
	要达到楼顶，还剩下 rest 步
	 */
	public static int process(int[] arr, int rest) {
		if (rest <= 1) {
			return 0;
		}

		//剩下两阶楼梯，下一步怎么走，取第一阶和第二阶中的小者
		if (rest == 2) {
			return Math.min(arr[0], arr[1]);
		}

		// 一步
		int value1 = process(arr, rest - 1) + arr[rest - 1];
		// 两步
		int value2 = process(arr, rest - 2) + arr[rest - 2];

		return Math.min(value1, value2);
	}

	/*
	rest 剩下多少阶楼梯
	 */
	public static int process1(int[] arr, int rest, int[] dp) {
		if (dp[rest] != -1) {
			return dp[rest];

		}
		if (rest <= 1) {
			dp[rest] = 0;
			return dp[rest];
		}

		//剩下两阶楼梯，下一步怎么走，取第一阶和第二阶中的小者
		if (rest == 2) {
			dp[rest] = Math.min(arr[0], arr[1]);
			return dp[rest];
		}

		// 一步
		int value1 = process1(arr, rest - 1, dp) + arr[rest - 1];
		// 两步
		int value2 = process1(arr, rest - 2, dp) + arr[rest - 2];

		dp[rest] = Math.min(value1, value2);
		return dp[rest];
	}

	public static int processdp(int[] arr) {
		int[] dp = new int[arr.length + 1];
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= arr.length; i++) {
			// 一步
			int value1 = dp[i - 1] + arr[i - 1];
			// 两步
			int value2 = dp[i - 2] + arr[i - 2];

			dp[i] = Math.min(value1, value2);
		}

		return dp[arr.length];
	}
}
