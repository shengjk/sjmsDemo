//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 0 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串
// 👍 1549 👎 0

package leetcode.editor.cn;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		Solution solution = new LongestCommonPrefix().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		//横向遍历获取 前缀str  前缀字符串一定满足 lcp(s0)>=lcp(s0,s1)>=lcp(s0,s2)>=lcp(s0,s3)>=...>=lcp(s0,sn)
		public String longestCommonPrefix(String[] strs) {
			if (strs == null || strs.length == 0) {
				return "";
			}
			//假设最长前缀str 是 strs[0]
			String prefix = strs[0];
			for (int i = 1; i < strs.length; i++) {
				//获取 lcp(s0,si)
				int length = Math.min(prefix.length(), strs[i].length());
				int index = 0;
				while (index < length && prefix.charAt(index) == strs[i].charAt(index)) {
					index++;
				}
				prefix = prefix.substring(0, index);

				//
				if (prefix.length() == 0) {
					break;
				}
			}
			return prefix;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
