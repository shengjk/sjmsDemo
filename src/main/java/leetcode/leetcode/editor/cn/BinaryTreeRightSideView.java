//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 356 👎 0


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	public static void main(String[] args) {
		Solution solution = new BinaryTreeRightSideView().new Solution();
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
// 广度优先遍历
	class Solution {
		public List<Integer> rightSideView(TreeNode root) {
			List<Integer> res = new ArrayList<>();
			if (root == null) {
				return res;
			}
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					root = queue.poll();
					if (root.left != null) {
						queue.offer(root.left);
					}
					if (root.right != null) {
						queue.offer(root.right);
					}
					
					if (i == size - 1) {
						res.add(root.val);
					}
				}
			}
			return res;
		}
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			val = x;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}