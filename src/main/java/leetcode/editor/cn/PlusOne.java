//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//
//
// 示例 1：
//
//
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
//
//
// 示例 2：
//
//
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
//
//
// 示例 3：
//
//
//输入：digits = [0]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics 数组
// 👍 659 👎 0

package leetcode.editor.cn;

public class PlusOne {
	public static void main(String[] args) {
		Solution solution = new PlusOne().new Solution();
		int[] nums = {1, 2, 3};
		int[] result = solution.plusOne(nums);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] plusOne(int[] digits) {
			int length = digits.length;
			int[] ans = new int[length];
			boolean carry = false;
			for (int i = length - 1; i >= 0; i--) {
				// only 最后一位
				int res = digits[i];
				if (i == length - 1) {
					res = digits[i] + 1;
				}

				res += (carry ? 1 : 0);

				if (res - 9 > 0) {
					ans[i] = res - 10;
					carry = true;
				} else {
					ans[i] = res;
					carry = false;
				}
			}

			//最后进一位单独处理
			if (carry) {
				int[] ans1 = new int[length + 1];
				ans1[0] = 1;
				int j = 1;
				for (int i = 0; i < ans.length; i++) {
					ans1[j] = ans[i];
				}
				ans = ans1;
			}
			return ans;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
