
> **欢迎阅读、点赞、转发、订阅，你的举手之间，我的动力源泉。**

![f03f03554eaedee467067b1d9451e96db2aa0f7fb9237211f66271431d4d87cc-0 (1).png](https://pic.leetcode-cn.com/b0c0b8f7982f38c5d19ae4f3d380293aff4c0a024df116166d27614c91e42d03-f03f03554eaedee467067b1d9451e96db2aa0f7fb9237211f66271431d4d87cc-0%20\(1\).png)




###### 一些名词

- 最长上升子序列(*LIS*):`Longest Increasing Subsequence `
- 最长连续序列(*LCS*):`Longest Consecutive Sequence `
- 最长连续递增序列(*LCIS*):`Longest Continuous Increasing Subsequence`
- 最长公共子序列(*LCS*):`Longest Common Subsequence`


> **最近重构了此文，做成了一个系列:<Deer系列>，希望能帮到大家**



| 题号      | 链接                                                         | 备注 |
| --------- | ------------------------------------------------------------ | ---- |
| 300       | [动态规划解最长子序列子串等一类问题之最长上升子序列[Thorold's Deer]](https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-jie-zui-chang-zi-xu-lie-zi-chua-3/) |      |
| 673/674   | [动态规划解最长子序列子串等一类问题之最长连续递增序列[Reindeer]](https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/solution/dong-tai-gui-hua-jie-zui-chang-zi-xu-lie-zi-chua-4/) |      |
| 1312      | [动态规划解最长子序列子串等一类问题之让字符串成为回文及其Follow Up[Sika Deer]](https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/solution/dong-tai-gui-hua-jie-zui-chang-zi-xu-lie-zi-chuan-/) |      |
| 128/LC397 | [动态规划解最长子序列子串等一类问题之最长连续子序列[White-lipped Deer]](https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/dong-tai-gui-hua-jie-zui-chang-zi-xu-lie-zi-chua-5/) |      |
| 1143      | [动态规划解最长子序列子串等一类问题之最长公共子序列[Hog Deer]](https://leetcode-cn.com/problems/longest-common-subsequence/solution/a-fei-xue-suan-fa-zhi-by-a-fei-8/) |      |

##### 举一反三：牛牛的数列

###### 方法 1：DP
- 牛牛现在有一个 *n* 个数组成的数列，牛牛现在想取一个连续的子序列，并且这个子序列还必须得满足：最多只改变一个数，就可以使得这个连续的子序列是一个严格上升的子序列，牛牛想知道这个连续子序列最长的长度是多少。
- *output*：一个整数，表示最长长度
- 这一题注意是求连续的
- 准备两个 *dp array*，*start* 表示以 *nums[i]* 开始的的最长递增连续子序列的长度，*end*  表示以 *nums[i]*  结束的最长递增连续子序列的长度，
- 初始化 *start[n-1] =1* (表示最后一个字符开始的最长连续子序列的长度，即其本身，长度为  *1*)，初始化  *end[0] =1*(  表示第一个字符结束的最长连续子序列的长度，即其本身，长度为  *1*)
- 注意  *start*  和 *end*  的生成的  *loop*  顺序
- 然后取i位置，当 *nums[i-1]<nums[i+1]* 表示可以形成一段连续递增子序列，只需要改i位置的值就可以了，然后取 *sum= start[i + 1] + end[i - 1] + 1*; 表示以  *i-1*  位置结束的数最长递增子序列和  `i+1` 开始的最长递增子序列可以连起来
例如 *{7 2 3 1 5 6}*，*end[0]* 表示以 7. 结束的，*end[0] =1*，*end[1]* 表示以 2 结束的，*end[1] =1*,*end[2]=2*，*end[3]=1*，*end[4]=2*，*end[5]=3*，同理可的 *start* 的

```java []
public static int lengthOfContinusLIS(int[] nums, int n) {
        int[] start = new int[n];
        int[] end = new int[n];
        end[0] = 1;
        for (int i = 1; i < n; i++) {
            end[i] = nums[i] > nums[i - 1] ? end[i - 1] + 1 : 1;
        }
        start[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            start[i] = nums[i] < nums[i + 1] ? start[i + 1] + 1 : 1;
        }
        int result = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] < nums[i + 1]) {
                int sum = start[i + 1] + end[i - 1] + 1;
                result = Math.max(result, sum);
            }
        }
        return result;
    }
```
```python []
console("hello world!")
```

##### 举一反三：非严格上升子序列

- 这一题同举一反三：牛牛的数列

##### 857. 最小的窗口子序列[LC] Hard TODO
- 同 `LeetCode` 727

#### *PART2*:谈谈动态转移方程 
##### 子串、子序列、回文的动态转移方程：

##### `LC-300`:最长上升子序列`Longest Increasing Subsequence` /`LIS`
  - `dp[i]` 表示的是 `s[0...i]` 这个范围内的最长上升子序列的长度
  - `base case`:`s[0]` 时，长度为 `1`，字符本身可以形成一个上升子序列，故 `dp[0]=1`
  - 其他情况下，需要探测下 `i`  之前的数，假如到了 `nums[j]` 这个数，有两种情况
    - `nums[j]>=nums[i]`，这种情况下对于结果没有意义，因为上升子序列的话，需要前面的数 `nums[j]` 比 `nums[i]`小，才可以形成一个上升子序列
    - `nums[j]<nums[i]`，也就是 `[0...j]`  这个范围内已经形成的上升子序列加上`nums[i]`这个数后可以形成一个新的上升子序列，显然：*dp[i]=max(dp[i],dp[j]+1)|j∈[0,i)*
[![8IRuQK.png](https://pic.leetcode-cn.com/1ba8f955bbbd9646e47b5f4d88c4ba5e1d702e6816415b23d22e726927288bbc.png)](https://imgchr.com/i/8IRuQK)
    - 举例：
	    [![85QBTI.png](https://pic.leetcode-cn.com/f82b87253152ca147663703d4ccbf4fdef13a8d34e9ec03c8e9f6ed29a9aff5b.png)](https://imgchr.com/i/85QBTI)
        - 当  `i=2` 时，因为前面没有比  `nums[2]=2 `小的数，所以 `dp[2]=1`,也就是说以 `nums[2]=2`  结尾的最长上升子序列，是其本身，长度为 `1`
        - 当  `i=3`,前面比起小的数只出现在索引  `2`，`[2,5]` 可以形成一个上升子序列，因此 `dp[3]=max(dp[3],dp[2]+1)=2`
        - 当  `i=5` 时，`dp[5]=max(dp[5],dp[3]+1)=3`


##### `LC-516`:最长回文子序列`Longest Palindromic Subsequence`/`LPS`

- **本题只涉及一个字符串，但是在组成 `dp `时，需要用到两个字符数组**

  [![8IXB0s.png](https://pic.leetcode-cn.com/ca068b56174ba01b926af096db7375465824bdd3cfc95bb1f327f92482458566.png)](https://imgchr.com/i/8IXB0s)


- **`dp[i][j]` 表示的是字符 `s[i...j]这个范围内的最长回文子序列的长度`**，记住子序列可以跳跃，`i` 的值小于 `j` 的值
- 当 `s[i]==s[j]`，可以很容易想到，根据 `dp` 的思想，要找其子问题，也就是 `dp[i+1][j-1]`，即 `s[i+1....j-1]`  这个字符串区间范围内的值，再加上 `s[i]`与`s[j]`  已经形成了回文，要加上长度 `2`，得结果:*dp[i][j]=dp[i+1][j-1]+2*

- 当 `s[i]!=s[j]`，还是要找其子问题，有两种情况：
  - 求出 `dp[i+1][j]`，也就是 `s[i+1....j]` 字符串范围上的最大回文子序列
  - 求出 `dp[i][j-1]`，也就是 `s[i....j-1]` 字符串范围上的最大回文子序列
  - 因为 `s[i]`与`s[j]`  不能形成回文，故此：*dp[i][j]=max(dp[i+1][j],dp[i][j-1])*

- 做出的  `dp table`，两种遍历方式，斜着遍历或者倒着遍历

[![8o994s.png](https://pic.leetcode-cn.com/4922e6e851d2ec7055e4d076d71c74b7e55fd1fd1143cb7178419e87cffc0a55.png)](https://imgchr.com/i/8o994s)


[![8o9SEQ.png](https://pic.leetcode-cn.com/1af79780bdd1077898c5ade4a4aed37ac9c40bcabca1632c386da76f3dd7c9dc.png)](https://imgchr.com/i/8o9SEQ)




---




#### **更多内容，欢迎订阅**

| 地址                                                      | 备注                       |
| ------------------------------------------------------------ | -------------------------- |
| [**力扣题解导航-阿飞算法**](https://wat1r.github.io/2020/09/03/leetcode-manualscripts-navigator/) | 过往题解导航入口，持续更新 |
| [**geek-algorithm-leetcode**](https://github.com/wat1r/geek-algorithm-leetcode) | 代码仓库                   |
| **阿飞算法**                                                    | 微信公众号，扫描见底部     |
| [**forloop.top**](http://forloop.top)                            | 技术博客，快餐博客         |

![qrcode_for_gh_76cb721bf802_258.jpg](https://pic.leetcode-cn.com/1efb09949e376b9cd1662efee85650d04c96dbf7a24985ce7d5cd75b5c3e3c7f-qrcode_for_gh_76cb721bf802_258.jpg)




