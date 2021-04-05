package xmht.datastructuresandalgorithms.msb.write_hard.recursion;

/**
 * @author shengjk1
 * @date 2021/3/31
 */
public class MaxCommonSequences {

	public static int processdp(char[] str1, char[] str2) {
		// ingonre 基本判断

		int L1 = str1.length;
		int L2 = str2.length;

		int[][] dp = new int[L2][L1];

		//确定 base case
		dp[0][0] = str1[0] == str2[0] ? 1 : 0;
		for (int i = 1; i < L1; i++) {
			dp[0][i] = Math.max(dp[0][i - 1], (str1[i] == str2[0] ? 1 : 0));
		}
		for (int i = 1; i < L2; i++) {
			dp[i][0] = Math.max(dp[0][i - 1], (str1[0] == str2[i] ? 1 : 0));
		}

		for (int i = 0; i < L2; i++) {
			for (int j = 0; j < L1; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (str1[j] == str2[i]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}

		return dp[L2 - 1][L1 - 1];
	}
}
