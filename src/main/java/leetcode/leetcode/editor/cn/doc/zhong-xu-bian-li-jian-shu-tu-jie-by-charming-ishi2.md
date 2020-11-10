**总体思路**

对于一个有序链表，先将左半边元素生成左子树，再将中间的元素生成根结点，最后将右半边元素生成右子树。将上述三个部分连在一起就是一个平衡二叉树。生成左，右子树是规模更小的子问题，可以递归求解。

**步骤图解**

build(i，j)表示以链表第i个节点开始，以第j个节点结束的元素构建平衡二叉树。current为当前指向链表的指针。以样例数据为例，要求解build(0, 4)，会一直递归求解直到第一个元素。
![1.png](https://pic.leetcode-cn.com/0fdfe8a6ca75136e804fc3719458e0492c4f242ece78075276241989707ec161-1.png)

每次完成一层递归会生成一个节点（即根节点），current指针会同步往后移动一个。
![2.png](https://pic.leetcode-cn.com/5dad1dd5759f3a715ae85d126f0e822872ee7f803c497bccd5b02c653efb5d42-2.png)

按照相同的方法生成右子树。
![3.png](https://pic.leetcode-cn.com/4c9d7b087bcb9a2b7a29ac53fb0b3dfd9501cc41fcfaff812459451406241862-3.png)

将右子树连接到根结点上，返回答案。
![4.png](https://pic.leetcode-cn.com/1c68ba4c4c75e85aa4d5243b933b21336e38977e9261421e19a3a3baf33e525f-4.png)

**参考代码**
```JAVA
class Solution {
    ListNode curr;

    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        for (ListNode i = head; i != null; i = i.next) {
            len = len + 1;
        }
        curr = head;
        return build(0, len - 1);
    }

    TreeNode build(int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode();
        if (left == right) {
            root.val = curr.val;
            curr = curr.next;
        }else {
            // 计算中点位置
            int mid = (left + right + 1) / 2;
            // 构建左子树
            root.left = build(left, mid - 1);
            // 左子树构建完后，curr指针刚好移动到mid处，给root赋值
            root.val = curr.val;
            // 使用了curr的值后，需要将curr指针向后移动
            curr = curr.next;
            // 构建右子树，并连接到根节点上
            root.right = build(mid + 1, right);
        }
        return root;
    }
}
```
