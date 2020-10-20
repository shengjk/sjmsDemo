//峰值元素是指其值大于左右相邻值的元素。 
//
// 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。 
//
// 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。 
//
// 你可以假设 nums[-1] = nums[n] = -∞。 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1]
//输出: 2
//解释: 3 是峰值元素，你的函数应该返回其索引 2。 
//
// 示例 2: 
//
// 输入: nums = [1,2,1,3,5,6,4]
//输出: 1 或 5 
//解释: 你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
// 
//
// 说明: 
//
// 你的解法应该是 O(logN) 时间复杂度的。 
// Related Topics 数组 二分查找 
// 👍 315 👎 0


package leetcode.leetcode.editor.cn;

import java.util.Objects;

public class FindPeakElement {
	public static void main(String[] args) {
		Solution solution = new FindPeakElement().new Solution();
		int[] ints = {3, 4, 3, 2, 1};
		solution.findPeakElement(ints);
	}
	
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int findPeakElement(int[] nums) {
			if (Objects.isNull(nums)) {
				return -1;
			}
			//判断首位
			if (nums.length == 1 || nums[0] > nums[1]) {
				return 0;
			}
			//判断末位
			if (nums[nums.length - 1] > nums[nums.length - 2]) {
				return nums.length - 1;
			}
			//排除首位和末位
			int L = 1;
			int R = nums.length - 2;
			while (L <= R) {
				int mid = L + (R - L) / 2;
				if (nums[mid] < nums[mid - 1]) {
					R = mid - 1;
				} else if (nums[mid] < nums[mid + 1]) {
					L = mid + 1;
				} else {
					return mid;
				}
			}
			return -1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}