//给定一个正整数，返回它在 Excel 表中相对应的列名称。
//
// 例如，
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB
//    ...
//
//
// 示例 1:
//
// 输入: 1
//输出: "A"
//
//
// 示例 2:
//
// 输入: 28
//输出: "AB"
//
//
// 示例 3:
//
// 输入: 701
//输出: "ZY"
//
// Related Topics 数学
// 👍 328 👎 0

package leetcode.editor.cn;

public class ExcelSheetColumnTitle {
	public static void main(String[] args) {
		Solution solution = new ExcelSheetColumnTitle().new Solution();
		solution.convertToTitle(26);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String convertToTitle(int columnNumber) {
			StringBuilder sb = new StringBuilder();
			while (columnNumber > 0) {
				//数字转化为字符
				int pop = (columnNumber - 1) % 26;
				sb.append((char) ('A' + pop));
				columnNumber = (columnNumber - 1) / 26;
			}
			return sb.reverse().toString();
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
