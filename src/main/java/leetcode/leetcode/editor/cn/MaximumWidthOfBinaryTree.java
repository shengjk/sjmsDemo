//给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节
//点为空。 
//
// 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。 
//
// 示例 1: 
//
// 
//输入: 
//
//           1
//         /   \
//        3     2
//       / \     \  
//      5   3     9 
//
//输出: 4
//解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
// 
//
// 示例 2: 
//
// 
//输入: 
//
//          1
//         /  
//        3    
//       / \       
//      5   3     
//
//输出: 2
//解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
// 
//
// 示例 3: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2 
//       /        
//      5      
//
//输出: 2
//解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
// 
//
// 示例 4: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       /     \  
//      5       9 
//     /         \
//    6           7
//输出: 8
//解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
// 
//
// 注意: 答案在32位有符号整数的表示范围内。 
// Related Topics 树 
// 👍 158 👎 0


package leetcode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
	public static void main(String[] args) {
		Solution solution = new MaximumWidthOfBinaryTree().new Solution();
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
		public int widthOfBinaryTree(TreeNode root) {
			if (root == null) {
				return 0;
			}
			/// bfs, 利用完全二叉树的性质
			Queue<TreeNode> q = new LinkedList<>();
			q.offer(root);
			LinkedList<Integer> numbers = new LinkedList<>();
			int max = 1;
			// 第一个节点的编号为1
			numbers.offer(1);
			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					int index = numbers.poll();
					TreeNode n = q.poll();
					if (n.left != null) {
						q.offer(n.left);
						numbers.offer(2 * index + 1);
					}
					if (n.right != null) {
						q.offer(n.right);
						numbers.offer(2 * index + 2);
					}
				}
				if (numbers.size() >= 2) {
					max = Math.max(max, numbers.getLast() - numbers.getFirst() + 1);
				}
				
			}
			return max;
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
	}
//leetcode submit region end(Prohibit modification and deletion)

}