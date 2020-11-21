//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 533 👎 0


package leetcode.leetcode.editor.cn;

public class DiameterOfBinaryTree {
	public static void main(String[] args) {
		Solution solution = new DiameterOfBinaryTree().new Solution();
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
		//最长路径上的 nodes
		int ans;
		
		public int diameterOfBinaryTree(TreeNode root) {
			ans = 1;
			depth(root);
			return ans - 1;
		}
		
		public int depth(TreeNode root) {
			if (root == null) {
				return 0;
			}
//			System.out.println(ans);
			//左树深度
			int leftDepth = depth(root.left);
			//右树深度
			int rightDepth = depth(root.right);
			//以当前 node 为 root 节点所对应的最长路径
			ans = Math.max(ans, leftDepth + rightDepth + 1);
			//当前子树的最大深度
			return Math.max(leftDepth, rightDepth) + 1;
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