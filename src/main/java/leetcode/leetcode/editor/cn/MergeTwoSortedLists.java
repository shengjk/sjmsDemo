//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1365 👎 0


package leetcode.leetcode.editor.cn;

public class MergeTwoSortedLists {
	public static void main(String[] args) {
		Solution solution = new MergeTwoSortedLists().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode() {}
	 * ListNode(int val) { this.val = val; }
	 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null && l2 == null) {
				return null;
			}
			ListNode dump = new ListNode();
			ListNode temp = dump;
			while (l1 != null && l2 != null) {
				if (l1.val <= l2.val) {
					temp.next = l1;
					temp = l1;
					l1 = l1.next;
				} else {
					temp.next = l2;
					temp = l2;
					l2 = l2.next;
				}
			}
			
			if (l1 != null) {
				temp.next = l1;
			}
			if (l2 != null) {
				temp.next = l2;
			}
			return dump.next;
		}
	}
	
	public class ListNode {
		int val;
		ListNode next;
		
		ListNode() {
		}
		
		ListNode(int val) {
			this.val = val;
		}
		
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}