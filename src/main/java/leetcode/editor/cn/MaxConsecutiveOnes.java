//给定一个二进制数组， 计算其中最大连续 1 的个数。
//
//
//
// 示例：
//
//
//输入：[1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
//
//
//
//
// 提示：
//
//
// 输入的数组只包含 0 和 1 。
// 输入数组的长度是正整数，且不超过 10,000。
//
// Related Topics 数组
// 👍 224 👎 0

package leetcode.editor.cn;

public class MaxConsecutiveOnes {
	public static void main(String[] args) {
		Solution solution = new MaxConsecutiveOnes().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int findMaxConsecutiveOnes(int[] nums) {
			if (nums == null) {
				return -1;
			}

			int max = 0;
			int res = 0;
			for (int num : nums) {
				if (num == 1) {
					res++;
				} else {
					max = Math.max(max, res);
					res = 0;
				}
			}
			max = Math.max(max, res);
			return max;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
