//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//
//
// 示例 3：
//
//
//输入：root = []
//输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -104 <= Node.val <= 104
//
// Related Topics 树 深度优先搜索 递归
// 👍 655 👎 0

package leetcode.editor.cn;

public class BalancedBinaryTree {
	public static void main(String[] args) {
		Solution solution = new BalancedBinaryTree().new Solution();
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
		public boolean isBalanced(TreeNode root) {
			return process(root).isBalance;
		}

		class Infos {
			int     hight;
			boolean isBalance;

			public Infos(int hight, boolean isBalance) {
				this.hight = hight;
				this.isBalance = isBalance;
			}
		}

		public Infos process(TreeNode root) {
			if (root == null) {
				return new Infos(0, true);
			}
			Infos leftInfos = process(root.left);
			Infos rightInfos = process(root.right);

			int hight = Math.max(leftInfos.hight, rightInfos.hight) + 1;
			boolean isBalance = Math.abs(leftInfos.hight - rightInfos.hight) < 2 && leftInfos.isBalance && rightInfos.isBalance;

			return new Infos(hight, isBalance);
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
