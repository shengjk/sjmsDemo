//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 468 👎 0


package leetcode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	public static void main(String[] args) {
		Solution solution = new BinaryTreePostorderTraversal().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode() {}
	 * TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) {
	 * this.val = val;
	 * this.left = left;
	 * this.right = right;
	 * }
	 * }
	 */
	class Solution {
		public List<Integer> postorderTraversal(TreeNode root) {
			List<Integer> ans = new LinkedList<>();
			process(root, ans);
			return ans;
		}
		
		public void process(TreeNode root, List<Integer> ans) {
			if (root == null) {
				return;
			}
			process(root.left, ans);
			process(root.right, ans);
			ans.add(root.val);
		}
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode() {
		}
		
		TreeNode(int val) {
			this.val = val;
		}
		
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}