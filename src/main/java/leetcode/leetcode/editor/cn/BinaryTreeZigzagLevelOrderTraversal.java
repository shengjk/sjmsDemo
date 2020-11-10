//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 285 👎 0


package leetcode.leetcode.editor.cn;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String[] args) {
		Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			List<List<Integer>> lists = new LinkedList<List<Integer>>();
			if (root == null) {
				return lists;
			}
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			int count = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				ArrayList<Integer> integers = new ArrayList<>();
				for (int i = 0; i < size; i++) {
					root = queue.poll();
					integers.add(root.val);
					
					if (root.left != null) {
						queue.add(root.left);
					}
					if (root.right != null) {
						queue.add(root.right);
					}
				}
				if (count % 2 != 0) {
					Collections.reverse(integers);
				}
				lists.add(integers);
				count++;
			}
			return lists;
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