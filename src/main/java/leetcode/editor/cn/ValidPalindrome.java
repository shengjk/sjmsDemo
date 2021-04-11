//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串
// 👍 364 👎 0

package leetcode.editor.cn;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null) {
                return false;
            }
            if (s.trim().length() == 0) {
                return true;
            }
            int left = 0;
            int right = s.length() - 1;
            s = s.toLowerCase();
            while (left <= right) {
                char leftChar = s.charAt(left);
                boolean leftBoolean = (( leftChar>= 'a' && leftChar <= 'z') || (leftChar >= '0' && leftChar <= '9'));
                if (!leftBoolean) {
                    left++;
                    continue;
                }

                char rightChar = s.charAt(right);
                boolean rigthBoolean = (( rightChar>= 'a' && rightChar <= 'z') || (rightChar >= '0' && rightChar <= '9'));
                if (!rigthBoolean) {
                    right--;
                    continue;
                }

                if (leftBoolean && rigthBoolean) {
                    if (s.charAt(left) != s.charAt(right)) {
                        return false;
                    } else {
                        left++;
                        right--;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
