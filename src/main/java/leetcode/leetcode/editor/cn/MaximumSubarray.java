//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2202 👎 0


package leetcode.leetcode.editor.cn;

public class MaximumSubarray {
	public static void main(String[] args) {
		Solution solution = new MaximumSubarray().new Solution();
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(solution.maxSubArray(nums));
	}
	
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int maxSubArray(int[] nums) {
			//动态规划
			//Success: Runtime:1 ms, faster than 95.19% of Java online submissions. Memory Usage:40 MB, less than 34.83% of Java online submissions.
// 少遍历一次跟多遍历一次对性能基本上无影响，但对内存的影响会有点大
//			if (nums.length > 0) {
			int result = nums[0];
			int sum = 0;
			for (int num : nums) {
				if (sum < 0) {
					sum = num;
				} else {
					sum += num;
				}
				result = Math.max(result, sum);
			}
			return result;
//			} else {
//				return -1;
//			}
			//Success: Runtime:1 ms, faster than 95.19% of Java online submissions. Memory Usage:39.8 MB, less than 38.20% of Java online submissions.
//			int ans = nums[0];
//			int sum = 0;
//			for(int num: nums) {
//				if(sum > 0) {
//					sum += num;
//				} else {
//					sum = num;
//				}
//				ans = Math.max(ans, sum);
//			}
//			return ans;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}