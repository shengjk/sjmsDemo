//给出一个完全二叉树，求出该树的节点个数。 
//
// 说明： 
//
// 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为
//第 h 层，则该层包含 1~ 2h 个节点。 
//
// 示例: 
//
// 输入: 
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//输出: 6 
// Related Topics 树 二分查找 
// 👍 266 👎 0


package leetcode.leetcode.editor.cn;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int countNodes(TreeNode root) {
		    /*
		    Runtime:1 ms, faster than 18.96% of Java online submissions.
			Memory Usage:41 MB, less than 87.46% of Java online submissions.
		     */
            if (root == null) {
                return 0;
            }
            int left = countNodes(root.left);
            int right = countNodes(root.right);
            return left + right + 1;
			/*
			Runtime:0 ms, faster than 100.00% of Java online submissions.
			Memory Usage:40.9 MB, less than 91.17% of Java online submissions.
			 */
            //return root != null?1+countNodes(root.left)+countNodes(root.right):0;
        }
        
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            
            TreeNode(int x) {
                val = x;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}