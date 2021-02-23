## 102. 二叉树的层序遍历

**题目：**

给你一个二叉树，请你返回其按 **层序遍历** 得到的节点值。 （即逐层地，从左到右访问所有节点）。

**示例：**

```md
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
```

### 队列广度优先搜索

开局存入*root*节点，每次遍历当层全部节点，需要在循环开始时记录当层个数（关键），遍历当层节点的时候需要将下层节点加入队列（如果不为空）。

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.maxSubBSTSize();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
```

#### 复杂度分析

* 时间复杂度：*O(n)*

  遍历所有节点。
* 空间复杂度：*O(n)*

  队列中元素不超过*n*个。

我的博客：<https://me.csdn.net/qq_20067165?ref=miniprofile>