//给定一个Excel表格中的列名称，返回其相应的列序号。
//
// 例如，
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...
//
//
// 示例 1:
//
// 输入: "A"
//输出: 1
//
//
// 示例 2:
//
// 输入: "AB"
//输出: 28
//
//
// 示例 3:
//
// 输入: "ZY"
//输出: 701
//
// 致谢：
//特别感谢 @ts 添加此问题并创建所有测试用例。
// Related Topics 数学
// 👍 214 👎 0

package leetcode.editor.cn;

public class ExcelSheetColumnNumber {
	public static void main(String[] args) {
		Solution solution = new ExcelSheetColumnNumber().new Solution();
		solution.titleToNumber("ZY");
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int titleToNumber(String columnTitle) {
			if (columnTitle == null) {
				return -1;
			}
			char diff = 'A' - 1;
			int ans = 0;

			char[] chars = columnTitle.toCharArray();
			int powCount = 0;
			for (int i = chars.length - 1; i >= 0; i--) {
				ans += ((int) (chars[i] - diff)) * Math.pow(26, powCount++);
			}
			return ans;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
