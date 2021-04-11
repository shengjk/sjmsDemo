# 解题思路
**双指针：`left` 指针指向字符串的开头，`right` 指针指向字符串的结尾。**

**若 `left` 指针指向的字符不是数字或字母**，则令 **`left`** 指针右移一位然后继续比较。

**若 `right` 指针指向的字符不是数字或字母**，则令 **`right`** 指针左移一位然后继续比较。

**若两个指针指向的是大写字母**，则将其转换成小写字母后进行比较，比较结束后，令 **`left`** 和 **`right`** 指针分别移动一位，进行下两个字符的比较。

---
# 代码
```java
class Solution {

    public boolean isPalindrome(String s) {

        int n = s.length();
        if (n < 2) return true;

        int left = 0, right = n - 1;
        char a = 'a', b = 'b';
        while (left < right) {

            a = s.charAt(left);
            b = s.charAt(right);
            if (!((a >= '0' && a <= '9') || (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z'))){

                left++;
                continue;
            }

            if (!((b >= '0' && b <= '9') || (b >= 'a' && b <= 'z') || (b >= 'A' && b <= 'Z'))){

                right--;
                continue;
            }
            if (a >= 'A' && a <= 'Z') a += 32;
            if (b >= 'A' && b <= 'Z') b += 32;
            if (a != b) return false;
            left++;
            right--;
        }
        return true;
    }
}
```
时间复杂度：O(n)
空间复杂度：O(1)