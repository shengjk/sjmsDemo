//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 413 👎 0


package leetcode.leetcode.editor.cn;

public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			ListNode cur = head;
			while (cur != null) {
				ListNode next = cur.next;
				if (next == null) {
					break;
				}
				
				//找到下一个不相等的 node
				while (next != null && cur.val == next.val) {
					next = next.next;
				}
				cur.next = next;
				cur = next;
			}
			return head;
		}
		
		public class ListNode {
			int val;
			ListNode next;
			
			ListNode(int x) {
				val = x;
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}