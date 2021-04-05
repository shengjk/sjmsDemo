package xmht.datastructuresandalgorithms.msb.recursion;

/**
 * @author shengjk1
 * @date 2021/3/28
 * 两个字符串最长公共子序列
 */
public class MaxSubSequence {


	public static int maxSubSequence(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		return process(s1, s2);
	}

	public static int process(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();

		int[][] dp = new int[n1][n2];

		dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;

		//行填充
		for (int i = 1; i < s2.length(); i++) {
			dp[i][0] = Math.max(dp[i - 1][0], (s2.charAt(i) == s1.charAt(0) ? 1 : 0));
		}

		// 列填充
		for (int i = 1; i < s1.length(); i++) {
			dp[0][i] = Math.max(dp[0][i - 1], (s1.charAt(i) == s2.charAt(0) ? 1 : 0));
		}

		for (int i = 1; i < s2.length(); i++) {
			for (int j = 1; j < s1.length(); j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (s2.charAt(i) == s1.charAt(j)) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}

		}
		return dp[s2.length() - 1][s1.length() - 1];

	}
}
