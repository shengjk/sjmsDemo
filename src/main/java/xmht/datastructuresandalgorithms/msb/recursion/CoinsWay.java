package xmht.datastructuresandalgorithms.msb.recursion;

/**
 * @author shengjk1
 * @date 2021/3/28
 */
public class CoinsWay {

	public static int ways1(int[] arr, int rest) {
		if (arr == null || arr.length == 0 || rest < 0) {
			return 0;
		}
		return process1(arr, 0, rest);
	}

	public static int process1(int[] arr, int index, int rest) {
		if (index == arr.length) {
			return rest == 0 ? 1 : 0;
		}

		int ways = 0;
		for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
			ways += process1(arr, index + 1, rest - zhang * arr[index]);
		}
		return ways;
	}


	public static int ways2(int[] arr, int rest) {
		if (arr == null || arr.length == 0 || rest < 0) {
			return 0;
		}

		int N = arr.length;
		int[][] dp = new int[N + 1][rest + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}

		return process2(arr, 0, rest, dp);
	}

	public static int process2(int[] arr, int index, int rest, int[][] dp) {
		if (dp[index][rest] != -1) {
			return dp[index][rest];
		}
		if (index == arr.length) {
			dp[index][rest] = rest == 0 ? 1 : 0;
			return dp[index][rest];
		}

		int ways = 0;
		for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
			ways += process2(arr, index + 1, rest - zhang * arr[index], dp);
		}
		dp[index][rest] = ways;
		return dp[index][rest];
	}


	public static int ways3(int[] arr, int rest) {
		if (arr == null || arr.length == 0 || rest < 0) {
			return 0;
		}

		int N = arr.length;
		int[][] dp = new int[N + 1][rest + 1];
		dp[N][0] = 1;

		for (int index = N - 1; index >= 0; index--) {
			for (int i = 0; i <= rest; i++) {
				int ways = 0;
				for (int zhang = 0; zhang * arr[index] <= i; zhang++) {
					ways += dp[index + 1][i - (zhang * arr[index])];
				}
				dp[index][i] = ways;
			}
		}
		return dp[0][rest];
	}

	public static int ways4(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int N = arr.length;
		int[][] dp = new int[N + 1][aim + 1];
		dp[N][0] = 1;// dp[N][1...aim] = 0;
		for (int index = N - 1; index >= 0; index--) {
			for (int rest = 0; rest <= aim; rest++) {
				dp[index][rest] = dp[index + 1][rest];
				if (rest - arr[index] >= 0) {
					dp[index][rest] += dp[index][rest - arr[index]];
				}
			}
		}
		return dp[0][aim];
	}


	public static void main(String[] args) {
		int[] arr = {5, 10, 50, 100};
		int sum = 1000;
		System.out.println(ways1(arr, sum));
		System.out.println(ways2(arr, sum));
		System.out.println(ways3(arr, sum));
		System.out.println(ways4(arr, sum));
	}

}
