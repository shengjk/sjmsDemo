package xmht.datastructuresandalgorithms.msb.recursion;

/**
 * @author shengjk1
 * @date 2021/3/9
 */
public class RobotWalk {

	public static int ways1(int N, int M, int K, int P) {
		// 参数无效直接返回0
		if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
			return 0;
		}
		// 总共N个位置，从M点出发，还剩K步，返回最终能达到P的方法数
		return walk(N, M, K, P);
	}

	/*
	N: 位置 1-N 固定参数
	cur: 当前cur 位置
	rest:还剩 rest 步没走
	P: 最终目标 P 固定参数
	只能在 1~N这些位置上移动，当前 cur 位置，走完 rest 步之后，停在 P 位置

	 */
	public static int walk(int N, int cur, int rest, int P) {

		if (rest == 0) {
			return cur == P ? 1 : 0;
		}

		if (cur == 1) {
			return walk(N, 2, rest - 1, P);
		}
		if (cur == N) {
			return walk(N, N - 1, rest - 1, P);
		}

		return walk(N, cur + 1, rest - 1, P) + walk(N, cur - 1, rest - 1, P);
	}

	public static int ways2(int N, int M, int K, int P) {
		// 参数无效直接返回0
		if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
			return 0;
		}
		int[][] dp = new int[K + 1][N + 1];
		dp[0][P] = 1;
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				if (j == 1) {
					dp[i][j] = dp[i - 1][2];
				} else if (j == N) {
					dp[i][j] = dp[i - 1][N - 1];
				} else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
				}
			}
		}
		return dp[K][M];
	}

	public static void main(String[] args) {
		System.out.println(ways1(7, 4, 9, 5));
		System.out.println(ways2(7, 4, 9, 5));
	}

}
