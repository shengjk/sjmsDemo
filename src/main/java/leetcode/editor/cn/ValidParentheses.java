//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2309 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		Solution solution = new ValidParentheses().new Solution();
		solution.isValid("()");
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		private final Map<Character, Character> dict = new HashMap<Character, Character>() {{
			put('{', '}');
			put('[', ']');
			put('(', ')');
			put('?', '?');
		}};

		//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
		public boolean isValid(String s) {

			Stack<Character> stack = new Stack<>();
			char[] chars = s.toCharArray();
			for (char aChar : chars) {
				char keyValue = aChar;
				if (dict.containsKey(keyValue)) {
					stack.push(keyValue);
				} else {
					if (!stack.isEmpty()) {
						char s1 = dict.get(stack.pop());
						if (s1 != keyValue) {
							return false;
						}
					} else {
						return false;
					}
				}
			}
			return stack.isEmpty();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
