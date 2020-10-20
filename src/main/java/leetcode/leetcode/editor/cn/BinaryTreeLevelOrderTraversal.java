//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 669 👎 0


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
		public List<List<Integer>> levelOrder(TreeNode root) {
			LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
			if (root == null) {
				return list;
			}
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				ArrayList<Integer> integers = new ArrayList<>();
				
				for (int i = 0; i < size; i++) {
					TreeNode poll = queue.poll();
					integers.add(poll.val);
					if (poll.left != null) {
						queue.offer(poll.left);
					}
					if (poll.right != null) {
						queue.offer(poll.right);
					}
				}
				list.add(integers);
			}
			return list;
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