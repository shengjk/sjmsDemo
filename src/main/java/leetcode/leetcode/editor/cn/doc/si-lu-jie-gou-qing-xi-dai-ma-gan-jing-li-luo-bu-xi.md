
**分析：**
求一棵二叉树的最大深度，先分别求出左子树和右子树的深度，然后进行比较，结果就是较大的那个+1（根节点）。
**思路**
1. 递归终止条件（递归基）：越过叶子节点返回`0`；
2. 分别求出左右子树的最大深度`leftDepth` 和 `rightDepth`；
3. 返回较大值+1；


**代码**
```java []
class Solution {
    public int maxDepth(TreeNode root) {
        //越过叶子节点
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
```

![微信图片_20200920111113.jpg](https://pic.leetcode-cn.com/1600587322-rzKDaS-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200920111113.jpg)


