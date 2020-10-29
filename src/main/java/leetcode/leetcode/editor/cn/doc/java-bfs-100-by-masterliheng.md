### 解题思路
利用广度优先搜索的思路，还有完全二叉树的性质，对于编号为i的节点，左右节点的编号分别为2*i+1 和 2*i+2

### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        /// bfs, 利用完全二叉树的性质
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        LinkedList<Integer> numbers = new LinkedList<>();
        int max = 1;
        // 第一个节点的编号为1
        numbers.offer(1);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int index = numbers.poll();
                TreeNode n = q.poll();
                if(n.left!=null){
                    q.offer(n.left);
                    numbers.offer(2*index+1);
                }
                if(n.right!=null){
                    q.offer(n.right);
                    numbers.offer(2*index+2);
                }
            }
            if(numbers.size()>=2){
                max = Math.max(max, numbers.getLast()-numbers.getFirst()+1);
            }
            
        }
        return max;
    }
}
```