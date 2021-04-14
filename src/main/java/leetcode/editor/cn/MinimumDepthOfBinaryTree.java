//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明：叶子节点是指没有子节点的节点。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：2
//
//
// 示例 2：
//
//
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
//
//
//
//
// 提示：
//
//
// 树中节点数的范围在 [0, 105] 内
// -1000 <= Node.val <= 1000
//
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 486 👎 0

package leetcode.editor.cn;

public class MinimumDepthOfBinaryTree {
	public static void main(String[] args) {
		Solution solution = new MinimumDepthOfBinaryTree().new Solution();
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
		public int minDepth(TreeNode root) {
			if (root == null) {
				return 0;
			}
			// int leftMinDepth = minDepth(root.left);
			// int rightMinDepth = minDepth(root.right);
			// 说明 root.left || root.right 至少有一个为 null，因为距离是到叶子节点，所以应该去两者之间的较大者
			// return (leftMinDepth == 0 || rightMinDepth == 0) ? Math.max(leftMinDepth, rightMinDepth) + 1 : Math.min(leftMinDepth, rightMinDepth) + 1;
			//套路解
			return process(root);
		}

		public int process(TreeNode root) {
			if (root.left == null && root.right == null) {
				return 1;
			}

			int ans = Integer.MAX_VALUE;
			if (root.left != null) {
				ans = Math.min(process(root.left) + 1, ans);
			}
			if (root.right != null) {
				ans = Math.min(process(root.right) + 1, ans);
			}
			return ans;
		}
	}

	//leetcode submit region end(Prohibit modification and deletion)
	public class TreeNode {
		int      val;
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
}
