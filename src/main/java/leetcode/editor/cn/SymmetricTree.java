//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 1333 👎 0

package leetcode.editor.cn;

public class SymmetricTree {
	public static void main(String[] args) {
		Solution solution = new SymmetricTree().new Solution();
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
		public boolean isSymmetric(TreeNode root) {
			if (root == null) {
				return true;
			}
			// System.out.println(root);
			return pre(root.left, root.right);
		}

		public boolean pre(TreeNode node, TreeNode node1) {
			if (node == null || node1 == null) {
				return node == node1;
			}

			return (node.val == node1.val) && pre(node.left, node1.right) && pre(node.right, node1.left);
		}
	}

	//leetcode submit region end(Prohibit modification and deletion)

	public void pre(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.val);
		pre(root.left);
		pre(root.right);
	}

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
