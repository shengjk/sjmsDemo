//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
// Related Topics 树 深度优先搜索
// 👍 483 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public static void main(String[] args) {
		Solution solution = new BinaryTreePaths().new Solution();
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
		public List<String> binaryTreePaths(TreeNode root) {
			ArrayList<String> ans = new ArrayList<>();
			if (root == null) {
				return ans;
			}
			process(root, ans, root.val + "");
			return ans;
		}

		public void process(TreeNode root, List<String> ans, String path) {
			if (root.left == null && root.right == null) {
				ans.add(path);
				return;
			}

			if (root.left != null) {
				String leftPath = path + "->" + root.left.val;
				process(root.left, ans, leftPath);
			}
			if (root.right != null) {
				String rightPath = path + "->" + root.right.val;
				process(root.right, ans, rightPath);
			}
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

	public void pre(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root);
		pre(root.left);
		pre(root.right);
	}
}
