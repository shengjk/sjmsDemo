本题解包含**三数之和**以及**四数之和**。
这类问题的关键在于使用双指针进行遍历，排除一些不必要的判断以优化：
# 三数之和
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length <= 2 || nums == null)//初始判断
            return res;
        Arrays.sort(nums);//数组排序，O(nlogn)
        for (int k = 0; k < nums.length - 2; k++) {//k只能到倒数第三个
            if (nums[k] > 0)//最左边的都>0，不玩了
                break;
            if (k > 0 && nums[k] == nums[k - 1])//相等则跳过
                continue;
            int left = k + 1;
            int right = nums.length - 1;
            /*双指针开始工作啦！直至left和right相遇*/
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (sum < 0) {
                    /*相当于:
                    left++;
                    while (left < right && nums[left] == nums[left - 1])  left++;
                    */
                    while (left < right && nums[left] == nums[++left]);
                }
                else if (sum > 0) {
                    while (left < right && nums[right] == nums[--right]);
                }
                else {
                    //使用asList()方法将三个元素放入res
                    res.add(new ArrayList<Integer>
                            (Arrays.asList(nums[k], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[right]);
                }
            }
        }
        return res;
    }
}
```
算法复杂度为O(N^2)
# 四数之和

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (len <= 3 || nums == null)//初始判断
            return res;
        for (int i = 0; i < len - 3; i++) {//i只能到倒数第四个
            if (i > 0 && nums[i] == nums[i - 1])//相等跳过
                continue;
            /*如果i之后相邻的三个之和都比target大，不玩了，拜拜*/
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            /*nums[i]不够大啊，跳到下一轮循环*/
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target)
                continue;
            /*注意，j 从 i + 1 开始*/
            for (int j = i + 1; j < len - 2; j++) {
                /*这里判断条件也应该是 j > i + 1 */
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;
                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target)
                    continue;
                /*注意，left从 j + 1 开始 */
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        while (left < right && nums[left] == nums[++left]);
                    }
                    else if (sum > target) {
                        while (left < right && nums[right] == nums[--right]);
                    }
                    else {
                        res.add(new ArrayList<Integer>(Arrays.asList
                                (nums[i], nums[j], nums[left], nums[right])));
                        while (left < right && nums[left] == nums[++left]);
                        while (left < right && nums[right] == nums[--right]);
                    }
                }
            }
        }
        return res;
    }
}
```
算法复杂度为O(N^3)

